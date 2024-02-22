package com.pattern.factory;

/**
 * This is one of the concrete factories for the factory design pattern.
 */
public class MortalFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Mortal();
    }
}

