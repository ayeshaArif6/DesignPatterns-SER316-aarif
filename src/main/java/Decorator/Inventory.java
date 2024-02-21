package Decorator;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> weapons;

    public List<Item> getWeapons() {
        return weapons;
    }
    public Inventory() {
        this.weapons = new ArrayList<>();
    }

    public void addWeapon(Item weapon) {
        weapons.add(weapon);
    }

    public void displayWeapons() {
        System.out.println("Inventory Weapons:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getDescription());
        }
    }

    public Item getWeapon(int index) {
        if (index >= 0 && index < weapons.size()) {
            return weapons.get(index);
        } else {
            System.out.println("Invalid weapon index. Returning default weapon.");
            return new Sword(); // Return a default weapon (you can change this)
        }
    }
}