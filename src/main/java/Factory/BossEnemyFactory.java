package Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BossEnemyFactory implements EnemyFactory {
    private List<Enemy> bossEnemies;

    public BossEnemyFactory() {
        bossEnemies = new ArrayList<>();
        bossEnemies.add(new BossEnemy("Fae Lord", 700, "Fae lord that can wield the magic of multiple elements."));
        bossEnemies.add(new BossEnemy("Blood Hound", 650, "A hell hound that tracks the smell of blood."));
        bossEnemies.add(new BossEnemy("Lindwyrm", 800, "A dragon without wings. "));
        // Add more small enemies as needed
    }

    @Override
    public Enemy createEnemy() {
        Random random = new Random();
        int index = random.nextInt(bossEnemies.size());
        return bossEnemies.get(index);
    }
}
