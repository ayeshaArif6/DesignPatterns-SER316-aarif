package Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This is a concrete factory for the factory design pattern
 */
public class WarriorFactory implements CharacterFactory {

    private List<Character> warriors;
    public WarriorFactory() {
        warriors = new ArrayList<>();
        initializeFighters();
    }

    private void initializeFighters() {
        warriors.add(new Warrior("Warrior", 700, "Sword skills."));

    }

    @Override
    public Character createCharacter() {
        Random random = new Random();
        int index = random.nextInt(warriors.size());
        return warriors.get(index);
    }
}


