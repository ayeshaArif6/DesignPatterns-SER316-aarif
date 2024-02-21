package Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarriorFactory implements CharacterFactory {

    private List<Character> warriors;
    public WarriorFactory() {
        warriors = new ArrayList<>();
        initializeFighters(); // Initialize the list with fighter instances
    }

    private void initializeFighters() {
        // Add multiple Fighter instances with different attributes to the list
        warriors.add(new Warrior("Warrior", 300, "Mighty warrior that can wield a sword and shield."));

        // Add more fighters as needed
    }

    @Override
    public Character createCharacter() {
        // Randomly select a Fighter from the list
        Random random = new Random();
        int index = random.nextInt(warriors.size());
        return warriors.get(index);
    }
}


