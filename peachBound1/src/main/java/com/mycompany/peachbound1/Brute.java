package com.mycompany.peachbound1;

// author @cnir1
public class Brute extends Monster{

    private final StatusEffect debuff; 
    private int bleedChance;
    private int bleedDmg;

    
    Brute(int bleedChance, int bleedDmg, StatusEffect debuff){
        super("BRUTE Alfred", 100.0, DMG_TYPES.SLASH, 25, 50, 50, DMG_TYPES.MAGIC, DMG_TYPES.SLASH,50);
        this.bleedChance = 50;
        this.bleedDmg = 5;
        this.debuff = StatusEffect.BLEED;
        
    
        // String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense
    }

    public int getBleedChance(){
        return bleedChance;
    }
    public int getBleedDmg(){
        return bleedDmg;
    }
    public int setBleedChance(int bleedChance){
        this.bleedChance = bleedChance;
        return bleedChance;
    }
    public int setBleedDmg(int bleedDmg){
        this.bleedDmg = bleedDmg;
        return bleedDmg;
    }

    @Override
    double attack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, Player p) {
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
    double specialAttack(double dmg, DMG_TYPES dmg_type, DMG_TYPES str, int stamina, Player p) {
        if(str == p.getWeakness()){
            dmg = dmg + dmg*0.5;
        }
        // if strength is player weakness + 50% dmg 
        double curPlayerHealth = p.getHealth() - dmg;

        // take player current health substract from damage
        p.setHealth(curPlayerHealth);
        if(stamina >=25){
            bleed(bleedDmg, bleedChance, p);
            stamina -= 10;
        }
        return curPlayerHealth;
    }

    boolean bleed(int bleedDmg, int bleedChance, Player p){
        if (p.getDebuffs().contains(debuff)){
            return false;
        }
        p.getDebuffs().add(debuff);
        return true;
    }

    

    
}
