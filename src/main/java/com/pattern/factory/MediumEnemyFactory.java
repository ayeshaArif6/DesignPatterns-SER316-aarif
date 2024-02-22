package com.pattern.factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a concrete factory for the factory design pattern
 */
public class MediumEnemyFactory implements EnemyFactory {
    public List<Enemy> mediumEnemies;

    public MediumEnemyFactory() {
        mediumEnemies = new ArrayList<>();
        mediumEnemies.add(new MediumEnemy("Daemanti", 300, "A mind reader that can predict moves before they are made."));
        mediumEnemies.add(new MediumEnemy("Griffin", 290, "A mix between a dragon, lion, and lizard."));
        mediumEnemies.add(new MediumEnemy("Ghoul Face", 330, "An enemy that can turn invisible at will."));
        mediumEnemies.add(new MediumEnemy("Fallen Knight", 300, "A knight that has teamed up with the evil forces."));
        mediumEnemies.add(new MediumEnemy("Witch", 350, "A witch."));
    }

    @Override
    public Enemy createEnemy() {
        Random random = new Random();
        int index = random.nextInt(mediumEnemies.size());
        return mediumEnemies.get(index);
    }
}

