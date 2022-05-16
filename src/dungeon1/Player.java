/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon1;

import java.util.Random;

/**
 *
 * @author Dampi
 */
public class Player {
    // Player variables

    private int Health;
    private int AttackDamage;
    private int NumHealthPotions;
    private final int HealthPotionHealAmount; // Hur mycket health potions helar för.
    private final int HealthPotionDropChance;  // Procentchans för spelaren att få en health potion efter fight

    public Player(int health, int attackDamage, int numHealthPotions, int healthPotionHealAmount, int healthPotionDropChance) {
        Health = health;
        AttackDamage = attackDamage;
        NumHealthPotions = numHealthPotions;
        HealthPotionHealAmount = healthPotionHealAmount;
        HealthPotionDropChance = healthPotionDropChance;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) { //Setter för players health
        Health = health;
    }

    public void takeDamage(int damageTaken) { // Metod för att ta damage
        Health -= damageTaken;
    }

    public void healPlayer() { // Metod för att helea spelaren och ta bort en health potion från spelaren.
        
        Health += HealthPotionHealAmount;
        NumHealthPotions--;
        if (Health > 10 ) {
            setHealth(10);
        }

    }

    public int getAttackDamage() { // Metod för att hämta spelarens attackDamage
        return AttackDamage;
    }

    public void setAttackDamage(int attackDamage) { // Metod för att bestämma spelarens attackDamage
        AttackDamage = attackDamage;
    }

    public int getNumHealthPotions() { // Metod för att hämta antal health potions som spelaren har.
        return NumHealthPotions;
    }

    public void setNumHealthPotions(int numHealthPotions) { // Metod för att bestämma hur många health potions spelaren ska ha.
        NumHealthPotions = numHealthPotions;
    }

    public int getHealthPotionDropChance() { // Metod för att hämta vad spelaren har för procentchans att få en health potion drop.
        return HealthPotionDropChance;
    }

    public void addHealthPotions(int numberOfPotions) { // Lägger till en health potion
        NumHealthPotions += numberOfPotions;
    }

    public void checkLoot() { // Metod för att randomly ge spelaren en health potion efter fight.
        Random rand = new Random();
        if (rand.nextInt(100) < HealthPotionDropChance) {
            addHealthPotions(1);
            System.out.println("> The enemy dropped a health potion!");
            System.out.println("\n>You now have " + NumHealthPotions + " health potions.");
        }
    }
}
