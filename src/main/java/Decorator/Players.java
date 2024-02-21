package Decorator;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Item> equippedWeapons;
    private Inventory inventory;

    // Constructor to initialize the inventory
    public Players() {
        this.inventory = new Inventory();
        this.equippedWeapons = new ArrayList<>();
        // Initialize the player with a default weapon (you can change this)
        this.equippedWeapons.add(new Sword());
    }

    public void equipWeapon(Item weapon) {
        equippedWeapons.add(weapon);
    }

    // Add a weapon to the player's inventory
    public void addWeaponToInventory(Item weapon) {
        inventory.addWeapon(weapon);
    }

    // Get the player's inventory
    public Inventory getInventory() {
        return inventory;
    }

    // Display the player's inventory
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

    // Other methods for player actions...
}