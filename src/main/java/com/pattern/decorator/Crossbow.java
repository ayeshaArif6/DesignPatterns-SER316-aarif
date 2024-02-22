package com.pattern.decorator;

//Crossbow class is part of the weapons and implements the item interface.
public class Crossbow implements Item {
    @Override
    public String getDescription() {
        return "Crossbow";
    }

}

