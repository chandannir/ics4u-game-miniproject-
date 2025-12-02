/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peachbound1;

/**
 *
 * @author clemo1
 */

// Main Item class
public class Item {
    private String name;
    private String description;
    
    public Item(String name, String desc){
        this.name = name;
        description = desc;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return description;
    }
}

// Weapon Subclass
public class Weapon extends Item{
    
}


