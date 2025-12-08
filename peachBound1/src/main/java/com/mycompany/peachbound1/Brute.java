package com.mycompany.peachbound1;
import java.util.Random;

public class Brute extends Monster{

    private final StatusEffect debuff; 
    private double bleedChance;
    private int bleedDmg;

    
    public Brute(String name){
        super(name, 200, DMG_TYPES.SLASH, 35, 50, 10, DMG_TYPES.MAGIC, DMG_TYPES.SLASH,10);
        this.bleedChance = 0.5;
        this.bleedDmg = 5;
        this.debuff = StatusEffect.BLEED;
        
    
        // String name, double health, DMG_TYPES dmg_type, double dmg, int stamina, int defence, DMG_TYPES weakness, DMG_TYPES strength, int offense
    }

    public double getBleedChance(){
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
       
        if(stamina >=25){
            if(str == p.getWeakness()){
                dmg = dmg + dmg*0.5;
            }
            // if strength is player weakness + 50% dmg 
            double curPlayerHealth = p.getHealth() - dmg;
    
            // take player current health substract from damage
            p.setHealth(curPlayerHealth);

            bleed(bleedDmg, bleedChance, p);
            setStamina(stamina-10);
            return curPlayerHealth;
        }
        setStamina(stamina+10);
        return p.getHealth();
        
        
    }

    //inflict bleed
    boolean bleed(int bleedDmg, double bleedChance, Player p){
        Random random = new Random();
        if (p.getDebuffs().contains(debuff)){
            return false;
        }
        // block excutes 50% of the time
        if(random.nextDouble()< bleedChance){
            p.getDebuffs().add(debuff);
            return true;
        }
        return false; 
    }

    

    
}
