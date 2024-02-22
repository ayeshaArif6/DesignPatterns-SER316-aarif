package com.pattern.decorator;

/**
 * This class is for the weapon "sword" that implements the item interface.
 */
public class Sword implements Item {
    @Override
    public String getDescription() {
        return "Sword";
    }

}
