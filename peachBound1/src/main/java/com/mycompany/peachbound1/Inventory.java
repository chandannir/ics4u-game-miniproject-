// @author mesastraw
package com.mycompany.peachbound1;

import java.util.ArrayList;

public class Inventory {
    // These are what the player currently has equipped
    // They will be able to use these in combat
    private ArrayList<Ability> curr_abilities; // Possibly change this to an array since there is a limit of 3?
    private ArrayList<Consumable> consumables;
    private Weapon curr_weapon;

    // These are what the user has unlocked
    // and is able to select and swap
    private ArrayList<Weapon> weapons;
    private ArrayList<Ability> abilities;

    // For beta testing
    public Inventory() {
        curr_abilities = new ArrayList<>();

        consumables = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            consumables.add(new Consumable("Small consumable", "Small consumable heals 15 health", 15.0));
            consumables.add(new Consumable("Medium consumable", "Medium consumable heals 25 health", 25.0));
            consumables.add(new Consumable("Big consumable", "Big consumable heals 50 health", 50.0));
        }

        weapons = new ArrayList<>();
        weapons.add(new Weapon("Boring Sword", "A normal blade with not much going on", DMG_TYPES.SLASH, 12));
        weapons.add(new Weapon("Smashing Hammer", "A giant heavy hammer that destroys everything", DMG_TYPES.BLUNT, 32));
        weapons.add(new Weapon("Piercing spear", "A spear that is really good a poking things", DMG_TYPES.PIERCE, 20));

        abilities = new ArrayList<>();
        // String name, String desc, StatusEffect debuff)
        abilities.add(new Ability("Freeze", "Freezes an enemy", StatusEffect.FREEZE));
        abilities.add(new Ability("Stab", "Bleeds an enemy", StatusEffect.BLEED));
        abilities.add(new Ability("Punch", "Ruptures enemies", StatusEffect.RUPTURE));
    }

    public ArrayList<Ability> getCurrAbilities() {
        return curr_abilities;
    }

    public void setCurrAbilities(ArrayList<Ability> curr_abilities) {
        this.curr_abilities = curr_abilities;
    }

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }

    public void setConsumables(ArrayList<Consumable> consumables) {
        this.consumables = consumables;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public Weapon getCurrWeapon() {
        return curr_weapon;
    }

    public void setCurrWeapon(Weapon weapon) {
        this.curr_weapon = weapon;
    }

    public Consumable getSmallConsumable() {
        for (Consumable cons : consumables) {
            if (cons.getName().equals("Small consumable")) {
                return cons;
            }
        }

        return null; // Make this an optional in the future?
    }

    public Consumable getMediumConsumable() {
        for (Consumable cons : consumables) {
            if (cons.getName().equals("Medium consumable")) {
                return cons;
            }
        }

        return null; // Make this an optional in the future?
    }

    public Consumable getBigConsumable() {
        for (Consumable cons : consumables) {
            // Fix this search in the future
            if (cons.getName().equals("Big consumable")) {
                return cons;
            }
        }

        return null; // Make this an optional in the future?
    }
}