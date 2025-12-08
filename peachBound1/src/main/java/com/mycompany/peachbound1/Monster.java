package com.mycompany.peachbound1;
import java.util.ArrayList;
/**
 *
 * @author cnir1
 */

// Super class for all monster types
abstract class Monster {
    
    private String name;
    private double health;
    private DMG_TYPES dmg_type;
    private double dmg;
    private int stamina;
    private int defence;
    private int offense;
    private DMG_TYPES weakness;
    private DMG_TYPES strength;
    public ArrayList<StatusEffect> debuffs; 
    
    // Monster Constructor
    public Monster(String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense){
        this.name = name;
        this.health = health;
        this.dmg_type = dmg_type;
        this.dmg = dmg;
        this.stamina = stamina;
        this.defence = defence;
        this.weakness = weakness;
        this.strength = strength;
        this.offense = offense;
        debuffs = new ArrayList<>();
    }
    public ArrayList<StatusEffect> getDebuffs(){
        return debuffs;
    }
    public String getName(){
        return name;
    }
    public double getHealth(){
        return health;
    }
    public DMG_TYPES getDmgType(){
        return dmg_type;
    } 
    public double getDmg(){
        return dmg;
    }
    public int getStamina(){
        return stamina;
    }
    public int getDefence(){
        return defence;
    }
    public int getOffense(){
        return offense;
    }
    public DMG_TYPES getStrength(){
        return strength;
    } public DMG_TYPES getWeakness(){
        return weakness;
    } 
    
    public String setName(String name){
        this.name = name;
        return name;
    }
    public double setHealth(double health){
        this.health = health;
        return health; 
    }
    public DMG_TYPES setDmgType(DMG_TYPES dmg_type){
        this.dmg_type = dmg_type;
        return dmg_type;
    } 
    public double setDmg(double dmg){
        this.dmg = dmg;
        return dmg;
    }
    public int setStamina(int stamina){
        this.stamina = stamina;
        return stamina;
    }
    public int setDefence(int defence){
        this.defence = defence;
        return defence;
    }
    public int setOffense(int offense){
        this.offense = offense;
        return offense;
    }
    public DMG_TYPES setStrength(DMG_TYPES strength){
        this.strength = strength;
        return strength;
    } 
    public DMG_TYPES setWeakness(DMG_TYPES weakness){
        this.weakness = weakness; 
        return weakness;
    }
    
    abstract double attack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, Player p);
    abstract double specialAttack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, int stamina, Player p);

    public boolean block(int defenece, Player p, Weapon w){
        if(debuffs.contains(StatusEffect.FREEZE)){
            return false;
        }
        
        if(getHealth() == 200){
            setHealth(getHealth() + 50);
        }
        else{
            setHealth(getHealth() + 25);
        }
        return true;
    }
    
}
