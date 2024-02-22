package com.pattern.decorator;

// This class gives a concrete Helmet implementation
public class Helmet implements Item {
    @Override
    public String getDescription() {
        return "Helmet";
    }

}
