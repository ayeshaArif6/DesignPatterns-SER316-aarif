package com.pattern.factory;

/**
 * This is one of the concrete factories for factory design pattern.
 */

public class VampireFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Vampire();
    }
}
