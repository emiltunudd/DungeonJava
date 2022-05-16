/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon1;

/**
 *
 * @author Dampi
 */
public class Monster {

    private int Health;
    private int AttackDamage;
    private String Name;

    public Monster(int health, int attackDamage, String name) {
        Health = health;
        AttackDamage = attackDamage;
        Name = name;

    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getHealth() {
        return Health;
    }

    public void setAttackDamage(int attackDamage) {
        AttackDamage = attackDamage;
    }

    public int getAttackDamage() {
        return AttackDamage;
    }
    public void takeDamage(int damageTaken) {
        Health -= damageTaken;
    }
}
