package com.mycompany.peachbound1;

/**
 *
 * @author cnir1
 */

// Regular Monster Class
public class RegularMonster extends Monster{
    
    RegularMonster(){
        super("Alfred", 100.0, DMG_TYPES.SLASH, 25, 50, 50, DMG_TYPES.MAGIC, DMG_TYPES.SLASH,50);
    
        // String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense
    }
    
    @Override
    public double attack(double dmg, DMG_TYPES dmg_type,DMG_TYPES str, Player p){
        if(str == p.getWeakness()){
            dmg = dmg + dmg*0.5;
        }
        // if strength is player weakness + 50% dmg 
        double curPlayerHealth = p.getHealth() - dmg;

        // take player current health substract from damage
        p.setHealth(curPlayerHealth);
        return curPlayerHealth;
       
    }
     
    @Override
    public double specialAttack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, int stamina, Player p){
        return attack(dmg, dmg_type, str, p);
    }
    
}
