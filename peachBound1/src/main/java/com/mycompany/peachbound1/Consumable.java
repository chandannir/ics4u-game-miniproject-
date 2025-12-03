/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peachbound1;

/**
 *
 * @author clemo1
 */
public class Consumable extends Item{
    private double healNum;
    
    public Consumable(String name, String desc, double heal){
        super(name, desc);
        healNum = heal;
    }
    
    public double getHealAmount(){
        return healNum;
    }
    
    public void useHeal(Player p){
        p.setHealth(p.getHealth() + healNum);
        if (p.getHealth() > 100){
            p.setHealth(p.getHealth() - (p.getHealth() - 100));
        }
    }
}
