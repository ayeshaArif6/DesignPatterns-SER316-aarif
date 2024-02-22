package com.pattern.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a concrete factory for the factory design pattern.
 */
public class AssassinFactory implements CharacterFactory {

    public List<Character> assassin;

    public AssassinFactory() {
        assassin = new ArrayList<>();
        initializeAssassin();
    }

    private void initializeAssassin() {
        assassin.add(new Assassin("Assassin", 700, "Stealth."));

    }

    @Override
    public Character createCharacter() {
        // This randomly selects a fighter from the list
        Random random = new Random();
        int index = random.nextInt(assassin.size());
        return assassin.get(index);
    }
}


