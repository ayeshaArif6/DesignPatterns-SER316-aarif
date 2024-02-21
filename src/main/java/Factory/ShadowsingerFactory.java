package Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShadowsingerFactory implements CharacterFactory {

    private List<Character> shadowsinger;
    public ShadowsingerFactory() {
        shadowsinger = new ArrayList<>();
        initializeShadowsingers(); // Initialize the list with fighter instances
    }

    private void initializeShadowsingers() {
        // Add multiple Fighter instances with different attributes to the list
        shadowsinger.add(new Shadowsinger("Shadowsinger", 400, "Manipulate shadows."));

        // Add more fighters as needed
    }

    @Override
    public Character createCharacter() {
        // Randomly select a Fighter from the list
        Random random = new Random();
        int index = random.nextInt(shadowsinger.size());
        return shadowsinger.get(index);
    }
}


