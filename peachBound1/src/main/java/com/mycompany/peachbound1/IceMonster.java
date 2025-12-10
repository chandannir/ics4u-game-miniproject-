package com.mycompany.peachbound1;

import java.util.Random;

public class IceMonster extends Monster{

    private final StatusEffect debuff; 
    private double freezeChance;

    

    public IceMonster(String name, int offense, int defence) {
        super(name, 125.0, DMG_TYPES.MAGIC, 30, 50, defence, DMG_TYPES.BLUNT, DMG_TYPES.MAGIC, offense);
        this.debuff = StatusEffect.FREEZE;
        this.freezeChance = 0.3;
        // String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense
    }

    public double getFreezeChance(){
        return freezeChance;
    }
    
    public int setFreezeChance(int freezeChance){
        this.freezeChance = freezeChance;
        return freezeChance;
    }


    @Override
    double attack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, Player p) {
        if(debuffs.contains(StatusEffect.FREEZE)){  
            debuffs.remove(StatusEffect.FREEZE);
            return p.getHealth();
        }
        else if(debuffs.contains(StatusEffect.PARALYZE)){
            debuffs.remove(StatusEffect.PARALYZE);
            return p.getHealth();
        }
       if(p.getDebuffs().contains(StatusEffect.PARALYZE)){
            dmg = dmg + dmg*0.6;
        }
        
        if(str == p.getWeakness()){
            dmg = dmg + dmg*0.3;
        }
        // if strength is player weakness + 50% dmg 
        double curPlayerHealth = p.getHealth() - dmg;

        // take player current health substract from damage
        p.setHealth(curPlayerHealth);
        return curPlayerHealth;
        
    }

    @Override
    double specialAttack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, int stamina, Player p) {
        if(stamina >=25){
            if(debuffs.contains(StatusEffect.FREEZE)){
                debuffs.remove(StatusEffect.FREEZE);
                return p.getHealth();
            }
            else if(debuffs.contains(StatusEffect.PARALYZE)){
                debuffs.remove(StatusEffect.PARALYZE);
                return p.getHealth();
            }
            if(p.getDebuffs().contains(StatusEffect.PARALYZE)){
                dmg = dmg + dmg*0.6;
            }
            if(str == p.getWeakness()){
                dmg = dmg + dmg*0.3;
            }
            // if strength is player weakness + 50% dmg 
            double curPlayerHealth = p.getHealth() - dmg;
    
            // take player current health substract from damage
            p.setHealth(curPlayerHealth);

            freeze(freezeChance, p);
            setStamina(stamina-10);
            return curPlayerHealth;
        }
        setStamina(stamina+10);
        return p.getHealth();
    }

    boolean freeze(double freezeChance, Player p){
        Random random = new Random();
        // block excutes 30% of the time
        if(random.nextDouble()< freezeChance){
            p.getDebuffs().add(debuff);
            return true;
        }
        return false; 
    }
    
}
