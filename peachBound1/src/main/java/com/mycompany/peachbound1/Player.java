// @author mesastraw
package com.mycompany.peachbound1;

import java.util.ArrayList;

public class Player {
    private Inventory inventory;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory newInv) {
        inventory = newInv;
    }

    // Shouldnt this be handled bu the gui?
    public void openInventory() {

    }

    //
    public void attack(Monster target) {
        for (StatusEffect s : debuffs) {
            if (s == StatusEffect.FREEZE) {
                return;
            } else if (s == StatusEffect.PARALYZE) {
                return;
            } else if (s == StatusEffect.BLEED) {
                this.health -= 12;
            } else if (s == StatusEffect.BURN) {
                this.health -= 12;
            }
        }

        this.inventory.getCurrWeapon().useSkill(target);
    }

    public void useSkill(Ability ability) {
        for (StatusEffect s : debuffs) {
            if (s == StatusEffect.FREEZE) {
                return;
            } else if (s == StatusEffect.PARALYZE) {
                return;
            } else if (s == StatusEffect.BLEED) {
                if (this.health <= 12.0) {
                    // call the ending screen here
                }
                this.health -= 12.0;
            } else if (s == StatusEffect.BURN) {
                if (this.health <= 12.0) {
                    // call the ending screen here
                }
                this.health -= 12.0;
            }
        }
    }

    public void useConsumable(Consumable consumable) {
        if (debuffs.contains(StatusEffect.FREEZE)) {
            // Print message in text box that says frozen?
            return;
        }

        consumable.useHeal(this);
    }

    // Make sure to add status effect interaction
    public void block() {
        if (debuffs.contains(StatusEffect.FREEZE)) {
            // Print message in text box that says frozen?
            return;
        }
        // Figure our which combat system function to call
    }

    public void retreat() {
        if (debuffs.contains(StatusEffect.FREEZE)) {
            // Print message in text box that says frozen?
            return;
        }
        // Figure out combat system function
    }
}
