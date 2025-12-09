// @author mesastraw
package com.mycompany.peachbound1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player {
    private Inventory inventory;
    private int defense_lvl;
    private int offense_lvl;
    private double health;

    private DMG_TYPES weakness;
    private DMG_TYPES strength;
    private ArrayList<StatusEffect> debuffs;
    private boolean block;

    // For beta test
    public Player() {
        inventory = new Inventory();
        defense_lvl = 2;
        offense_lvl = 2;
        health = 100.0;
        weakness = DMG_TYPES.MAGIC;
        strength = DMG_TYPES.SLASH;
        debuffs = new ArrayList<>();
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    
    public DMG_TYPES getStrength(){
        return strength;
    }
    
    public DMG_TYPES getWeakness(){
        return weakness;
    }
    
    public ArrayList<StatusEffect> getDebuffs(){
        return debuffs;
    }

    public int getDefense_lvl() {
        return defense_lvl;
    }

    public void setDefense_lvl(int defense_lvl) {
        this.defense_lvl = defense_lvl;
    }

    public int getOffense_lvl() {
        return offense_lvl;
    }

    public void setOffense_lvl(int offense_lvl) {
        this.offense_lvl = offense_lvl;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory newInv) {
        inventory = newInv;
    }

    public void setBlock() {
        block = true;
    }

    public boolean getBlock() {
        return block;
    }

    public Weapon getCurWeapon() {
        return this.inventory.getCurrWeapon();
    }
    
    public boolean checkStatus(){
        for(int i = 0; i <= debuffs.size(); i ++){
            if(null != debuffs.get(i))switch (debuffs.get(i)) {
                case FREEZE -> {
                    debuffs.remove(i);
                    return true;
                }
                case PARALYZE -> {
                    debuffs.remove(i);
                    return true;
                }
                case BLEED -> {
                    if (this.health <= 12.0) {
                        PeachBound1.combatScreen.Lose();
                    }   
                    this.health -= 12.0;
                    return false;
                }
                default -> {
                    return false; 
                }
            }  
        }
        return false;
    }
    public void attack(Monster target) {
        
        if (checkStatus()){
            return;
        }
        this.inventory.getCurrWeapon().useSkill(target);
        if (debuffs.contains(StatusEffect.BURN)) {
            if (this.health <= 12.0) {
                PeachBound1.combatScreen.Lose();
            }
            this.health -= 12.0;
        }
        
        PeachBound1.combatScreen.UpdateUI();
        }
    
    public void useSkill(Ability ability, Monster target) {
        if (checkStatus()){
            return;
        }    
        ability.useAbility(target);
        if (debuffs.contains(StatusEffect.BURN)) {
            if (this.health <= 12.0) {
                PeachBound1.combatScreen.Lose();
            }
            this.health -= 12.0;
        }
        
        PeachBound1.combatScreen.UpdateUI();
    }

    public boolean useConsumable(Consumable consumable) {
        if (checkStatus()){
            return false; 
        }
        
        try{
            consumable.useHeal(this);
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(
            null,
            "Item is not in inventory!",
            "Error",
            JOptionPane.ERROR_MESSAGE
            );
            
            this.health += 12;
            return false;
        }
        
        if (debuffs.contains(StatusEffect.BURN)) {
            if (this.health <= 12.0) {
                PeachBound1.combatScreen.Lose();
            }
            this.health -= 12.0;
        }
        
        PeachBound1.combatScreen.UpdateUI();
        return true;   
    }

    // Make sure to add status effect interaction
    public void block (Monster mons) {
        block = true;
        if (debuffs.contains(StatusEffect.FREEZE)) {
            // Print message in text box that says frozen?
            block = false;
        }
        
        // if monster attack_lvl > defense_lvl half damaga
        if (block && mons.getOffense() > defense_lvl) {
            this.setHealth(this.getHealth() - (mons.getDmg() / 2.0));
        }
        else{
            if(!block){
                this.setHealth(this.getHealth() - (mons.getDmg()));
            }
        }
        
        if (this.health <= 0) {
            PeachBound1.combatScreen.Lose();
        }
        
        if(mons.debuffs.contains(StatusEffect.BLEED)){
            mons.setHealth(mons.getHealth() - 12);
        }
        
        if(mons.debuffs.contains(StatusEffect.BURN)){
            mons.setHealth(mons.getHealth() - 12);
        }
        
        // if defese_lvl >= monster_attack block all
        PeachBound1.combatScreen.UpdateUI();
    }
}