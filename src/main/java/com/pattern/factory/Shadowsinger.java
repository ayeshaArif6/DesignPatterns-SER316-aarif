package com.pattern.factory;

/**
 * This is a concrete product for the factory design pattern.
 */
public class Shadowsinger implements Character {
    private String name;
    private int healthPoints;
    private String description;


    public Shadowsinger(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Shadowsinger named " + getName() + " with " +
                getHealthPoints() + " health points. Description: " + getDescription());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

