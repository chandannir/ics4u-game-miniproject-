package com.mycompany.peachbound1;

import java.util.Random;

public class FireMonster extends Monster{
    
    private final double burnChance;
    private final int burnDmg; 
    private final StatusEffect debuff; 

    public FireMonster(String name) {
        super(name, 100.0, DMG_TYPES.MAGIC, 30, 50, 1, DMG_TYPES.PIERCE, DMG_TYPES.MAGIC, 1);
        this.debuff = StatusEffect.BURN;
        this.burnChance = 0.3;
        this.burnDmg = 10; 
    }

    
    public double getBurnChance(){
        return burnChance;
    }
    public int getBurnDmg(){
        return burnDmg;
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
            if(str == p.getWeakness()){
                dmg = dmg + dmg*0.3;
            }
            // if strength is player weakness + 50% dmg 
            double curPlayerHealth = p.getHealth() - dmg;
    
            // take player current health substract from damage
            p.setHealth(curPlayerHealth);

            burn(burnChance, p);
            setStamina(stamina-10);
            return curPlayerHealth;
        }
        setStamina(stamina+10);
        return p.getHealth();
    }

    boolean burn(double burnChance, Player p){
        Random random = new Random();
        if (p.getDebuffs().contains(debuff)){
            return false;
        }
        // block excutes 30% of the time
        if(random.nextDouble()< burnChance){
            p.getDebuffs().add(debuff);
            return true;
        }
        return false; 
    }
}
