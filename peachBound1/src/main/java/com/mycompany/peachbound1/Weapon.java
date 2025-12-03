/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peachbound1;

/**
 *
 * @author clemo1
 */
public class Weapon extends Item{
    private DMG_TYPES dmgType;
    private double dmgNum;
    
    public Weapon(String name, String desc, DMG_TYPES dmgType, double dmgNum){
        super(name, desc);
        this.dmgType = dmgType;
        this.dmgNum = dmgNum;
    }
    
    public DMG_TYPES getType(){
        return dmgType;
    }
    public double getDmg(){
        return dmgNum;
    }
    
    public void useSkill(Monster target){
        if(target.getStrength() == dmgType){
            target.setHealth(target.getHealth() - dmgNum * 0.65);
        }
        else if(target.getWeakness() == dmgType){
            target.setHealth(target.getHealth() - dmgNum * 1.5);
        }
        else{
            target.setHealth(target.getHealth() - dmgNum * 1.5);
        }
    
        if(target.debuffs.contains(StatusEffect.RUPTURE)){
            target.setHealth(target.getHealth() - 15.0);
        }
    }
}
