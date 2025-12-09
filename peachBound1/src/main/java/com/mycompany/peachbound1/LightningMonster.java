package com.mycompany.peachbound1;

import java.util.Random;

public class LightningMonster extends Monster{
    private final double paraChance;
    private final StatusEffect debuff; 

    public LightningMonster(String name) {
        super(name, 100.0, DMG_TYPES.MAGIC, 30, 50, 1, DMG_TYPES.MAGIC, DMG_TYPES.SLASH, 1);
        this.paraChance = 0.3;
        this.debuff = StatusEffect.PARALYZE;
    }
    
    
    public double getParaChance(){
        return paraChance;
    }

    @Override
    double attack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, Player p) {
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

            para(paraChance, p);
            setStamina(stamina-10);
            return curPlayerHealth;
        }
        setStamina(stamina+10);
        return p.getHealth();
    }

    boolean para(double paraChance, Player p){
        Random random = new Random();
        // block excutes 30% of the time
        if(random.nextDouble()< paraChance){
            p.getDebuffs().add(debuff);
            return true;
        }
        return false; 
    }
}
