package Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a concrete factory for the factory design pattern
 */
public class SmallEnemyFactory implements EnemyFactory {
    public List<Enemy> smallEnemies;

    public SmallEnemyFactory() {
        smallEnemies = new ArrayList<>();
        smallEnemies.add(new SmallEnemy("Naga", 100, "Fast and agile demonic beast."));
        smallEnemies.add(new SmallEnemy("Hound", 80, "Monster that heavily relies on scenting its prey."));
        smallEnemies.add(new SmallEnemy("Zombie", 90, "A creature of the undead."));
        smallEnemies.add(new SmallEnemy("Wrym", 110, "Giant worm."));
        smallEnemies.add(new SmallEnemy("Baby Dragon", 140, "A slightly less vicious version of an adult dragon"));
        smallEnemies.add(new SmallEnemy("Goblin", 95,"Small green mini monster"));
        smallEnemies.add(new SmallEnemy("Hugo", 100,"Big flying beast with sharp claws."));
    }

    @Override
    public Enemy createEnemy() {
        Random random = new Random();
        int index = random.nextInt(smallEnemies.size());
        return smallEnemies.get(index);
    }
}
