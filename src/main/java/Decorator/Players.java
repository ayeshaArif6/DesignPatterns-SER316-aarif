package Decorator;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Item> equippedWeapons;
    private Inventory inventory;
    public int health;

    // This is the constructor for players that initializes the inventory.
    public Players(int initialHealth) {
        this.inventory = new Inventory();
        this.equippedWeapons = new ArrayList<>();
        this.equippedWeapons.add(new Sword());
        this.health = initialHealth;
    }

    public enum EnemyType {
        SMALL,
        MEDIUM,
        BOSS
    }

    public void equipWeapon(Item weapon) {
        equippedWeapons.add(weapon);
    }

    // This method adds a weapon to the player's inventory
    public void addWeaponToInventory(Item weapon) {
        inventory.addWeapon(weapon);
    }

    //This method gets the player's inventory
    public Inventory getInventory() {
        return inventory;
    }

    //This method displays the player's inventory
    public void displayInventory() {
        System.out.println("Current Inventory:");
        inventory.displayWeapons();
    }

    public void displayEquippedWeapons() {
        System.out.println("Equipped Weapons:");
        for (int i = 0; i < equippedWeapons.size(); i++) {
            System.out.println((i + 1) + ". " + equippedWeapons.get(i).getDescription());
        }
    }
    public List<Item> getEquippedWeapons() {
        return equippedWeapons;
    }

    //This method calculates damage based on the size of the enemy.
    public int calculateDamage(Players.EnemyType enemyType) {
        switch (enemyType) {
            case SMALL:
                return 10;
            case MEDIUM:
                return 30;
            case BOSS:
                return 50;
            default:
                return 0;
        }
    }

    public void decreaseHealth(EnemyType enemyType) {
        int damage;

        switch (enemyType) {
            case SMALL:
                damage = 10;
                break;
            case MEDIUM:
                damage = 30;
                break;
            case BOSS:
                damage = 50;
                break;
            default:
                damage = 0;
        }

        health -= damage;
        if (health < 0) {
            health = 0;  // This ensures health doesn't go below 0.
        }
    }

    public int getHealth() {
        return health;

    }

}