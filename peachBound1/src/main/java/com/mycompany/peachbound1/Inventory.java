package com.mycompany.peachbound1;

import java.util.ArrayList;

public class Inventory {
    // These are what the player currently has equipped
    // They will be able to use these in combat
    private ArrayList<Ability> curr_abilities; // Possibly change this to an array since there is a limit of 3?
    private ArrayList<consumable> consumables;
    private Weapon curr_weapon;

    // These are what the user has unlocked
    // and is able to select and swap
    private ArrayList<Weapon> weapons;
    private ArrayList<Ability> abilities;

    public Inventory() {

    }

    public Weapon getCurrWeapon() {
        return curr_weapon;
    }

    public void setCurrWeapon(Weapon weapon) {

    }

    public void selectConsumable() {

    }

    public void selectWeapon() {

    }

    public void selectAbility() {

    }
}
