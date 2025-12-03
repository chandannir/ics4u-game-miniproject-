/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peachbound1;

/**
 *
 * @author clemo1
 */
public class Ability extends Item{
    private StatusEffect statusEffect;
    
    public Ability(String name, String desc, StatusEffect debuff){
        super(name, desc);
        statusEffect = debuff;
    }
    
    public StatusEffect getEffect(){
        return statusEffect;
    }
    
    public void useAbility(Monster target){
        if (!target.debuffs.contains(statusEffect)){ // target does not have the debuff
            target.debuffs.add(statusEffect);
        }
    }
}
