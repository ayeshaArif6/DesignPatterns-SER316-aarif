package Decorator;
public class Players {
    private Item equippedWeapon;
    private Inventory inventory;

    public Players() {
        this.inventory = new Inventory();
        // Initialize the player with a default weapon (you can change this)
        this.equippedWeapon = new Sword();
    }

    public void pickWeaponFromInventory(int index) {
        equippedWeapon = inventory.getWeapon(index);
    }

    public void displayInventory() {
        inventory.displayWeapons();
    }

    // Other methods for player actions...
}