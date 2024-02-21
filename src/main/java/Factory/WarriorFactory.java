package Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FighterFactory implements CharacterFactory {

    private List<Character> fighters;
    public FighterFactory() {
        fighters = new ArrayList<>();
        initializeFighters(); // Initialize the list with fighter instances
    }

    private void initializeFighters() {
        // Add multiple Fighter instances with different attributes to the list
        fighters.add(new Fighter("AxeMaster", 100, "Mighty warrior skilled in the art of axes"));
        fighters.add(new Fighter("SwordKnight", 120, "Skilled knight wielding a powerful sword"));
        // Add more fighters as needed
    }

    @Override
    public Character createCharacter() {
        // Randomly select a Fighter from the list
        Random random = new Random();
        int index = random.nextInt(fighters.size());
        return fighters.get(index);
    }
}


