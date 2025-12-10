package com.mycompany.peachbound1;

/**
 *
 * @author cnir1
 */

// Regular Monster Class
public class RegularMonster extends Monster{
    
    public RegularMonster(String name){
        super(name, 100.0, DMG_TYPES.SLASH, 25, 50, 1, DMG_TYPES.MAGIC, DMG_TYPES.SLASH,1);
    
        // String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense
    }
    
    @Override
    public double attack(double dmg, DMG_TYPES dmg_type,DMG_TYPES str, Player p){
        if(debuffs.contains(StatusEffect.FREEZE)){
            return p.getHealth();
        }
        else if(debuffs.contains(StatusEffect.PARALYZE)){
            return p.getHealth();
        }
        if(p.getDebuffs().contains(StatusEffect.PARALYZE)){
           dmg = dmg + dmg*0.6;
        }
        if(p.getDebuffs().contains(StatusEffect.PARALYZE)){
            dmg = dmg + dmg*0.6;
        }
        if(str == p.getWeakness()){
            dmg = dmg + dmg*0.2;
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
