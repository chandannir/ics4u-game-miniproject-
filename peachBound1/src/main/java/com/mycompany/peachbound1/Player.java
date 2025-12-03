// @author mesastraw
package com.mycompany.peachbound1;

import java.util.ArrayList;

public class Player {
    private  Inventory inventory;
    private int defense_lvl;
    private int offense_lvl;
    private double health;

    private DMG_TYPES weakness;
    private DMG_TYPES strength; 
    private ArrayList<StatusEffect> debuffs;

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

    public void openInventory() {

    }

    public void attack(Weapon weapon) {

    }
    
    public void useSkill(Ability ability) {

    }

    public void useConsumable(Consumable consumable) {

    }

    // Make sure to add status effect interaction
    public void block() {

    }

    public void retreat() {

    }
}
