package Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssassinFactory implements CharacterFactory {

    private List<Character> assassin;
    public AssassinFactory() {
        assassin = new ArrayList<>();
        initializeAssassin(); // Initialize the list with fighter instances
    }

    private void initializeAssassin() {
        // Add multiple Fighter instances with different attributes to the list
        assassin.add(new Assassin("Assassin", 350, "Stealth."));

        // Add more fighters as needed
    }

    @Override
    public Character createCharacter() {
        // Randomly select a Fighter from the list
        Random random = new Random();
        int index = random.nextInt(assassin.size());
        return assassin.get(index);
    }
}


