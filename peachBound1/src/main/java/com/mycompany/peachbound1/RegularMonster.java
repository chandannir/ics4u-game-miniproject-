/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peachbound1;

/**
 *
 * @author cnir1
 */

// Regular Monster Class
public class RegularMonster extends Monster{
    
    RegularMonster(String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence){
        super(name, health, dmg_type, dmg, stamina, defence);
    }
    
    @Override 
    public double attack(double dmg, DMG_TYPES dmg_type, Player p){
        double curPlayerHealth = p.getHealth() - dmg;
        p.setHealth(curPlayerHealth);
        return curPlayerHealth;
       
    }
    @Override 
    public double specialAttack(double dmg, DMG_TYPES dmg_type, int stamina){
        
    }
        
    @Override 
    public void block(int defenece){
        
    }
}
