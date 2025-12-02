package com.mycompany.peachbound1;

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
    
    // Monster Constructor
    Monster(String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence){
        this.name = name;
        this.health = health;
        this.dmg_type = dmg_type;
        this.dmg = dmg;
        this.stamina = stamina;
        this.defence = defence;
    }
    
    abstract double attack(double dmg, DMG_TYPES dmg_type);
    abstract double specialAttack(double dmg, DMG_TYPES dmg_type, int stamina);
    abstract void block(int defenece);
}
