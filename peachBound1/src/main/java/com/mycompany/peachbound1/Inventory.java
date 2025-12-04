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
        ArrayList<Ability> curr_abilities = new ArrayList<>();
        ArrayList<Consumable> curr_consumables = new ArrayList<>();

        weapons = new ArrayList<>();
        weapons.add(new Weapon("Boring Sword", "A normal blade with not much going on", DMG_TYPES.SLASH, 12));
        weapons.add(new Weapon("Smashing Hammer", "A giant heavy hammer that destroys everything", DMG_TYPES.BLUNT, 32));
        weapons.add(new Weapon("Piercing spear", "A spear that is really good a poking things", DMG_TYPES.PIERCE, 20));

        curr_weapon = new Weapon("Boring Sword", "A normal blade with not much going on", DMG_TYPES.SLASH, 12);

        abilities = new ArrayList<>();
        // String name, String desc, StatusEffect debuff)
        abilities.add(new Ability("Freeze", ));

        consumables = new ArrayList<>();
    }

    public Weapon getCurrWeapon() {
        return curr_weapon;
    }

    public void setCurrWeapon(Weapon weapon) {
        this.curr_weapon = weapon;
    }

    public getSmallConsumable search() {

    }

    public getMediumConsumable search() {

    }

    public getBigConsumable search() {

    }
}