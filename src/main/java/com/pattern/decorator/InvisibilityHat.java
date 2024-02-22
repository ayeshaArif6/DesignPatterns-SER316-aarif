package com.pattern.decorator;

//This is a magic item that can be found in a chest.
public class InvisibilityHat implements Item {
    @Override
    public String getDescription() {
        return "Invisibility Hat";
    }
}

