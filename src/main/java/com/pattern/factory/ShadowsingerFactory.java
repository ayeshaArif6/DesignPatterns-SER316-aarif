package com.pattern.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a concrete factory for the factory design pattern.
 */
public class ShadowsingerFactory implements CharacterFactory {


    private List<Character> shadowsinger;
    public ShadowsingerFactory() {
        shadowsinger = new ArrayList<>();
        initializeShadowsingers();
    }

    private void initializeShadowsingers() {
        shadowsinger.add(new Shadowsinger("Shadowsinger", 700, "Manipulate shadows."));

    }

    @Override
    public Character createCharacter() {
        Random random = new Random();
        int index = random.nextInt(shadowsinger.size());
        return shadowsinger.get(index);
    }
}


