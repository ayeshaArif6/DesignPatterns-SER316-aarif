package com.pattern.decorator;

/**
 * This class is for the weapon "Shield" that implements the item interface.
 */
public class Shield implements Item {
    @Override
    public String getDescription() {
        return "Shield";
    }

}
