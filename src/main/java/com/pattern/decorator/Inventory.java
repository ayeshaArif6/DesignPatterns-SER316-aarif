package com.pattern.decorator;

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

}