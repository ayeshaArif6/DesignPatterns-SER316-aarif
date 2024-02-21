import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Factory.*;
import Factory.Character;
import Decorator.*;

public class Main {

    private List<Player> players;
    private List<Character> characters;

    private int currentFloor;
    public void incrementFloor() {
        this.currentFloor++;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void generateEnemy(EnemyFactory enemyFactory) {
        Enemy enemy = enemyFactory.createEnemy();
        enemy.displayInfo();
    }
    public Main() {
        players = new ArrayList<>();
        initializePlayers(); // Initialize the list with player instances

        characters = new ArrayList<>();
        initializeCharacters(); // Initialize the list with character instances

        this.currentFloor = 1;
        this.player = new Players();
        player.addWeaponToInventory(new Sword());
        player.addWeaponToInventory(new Shield());
        player.addWeaponToInventory(new Dagger());
        player.addWeaponToInventory(new Crossbow());
        player.addWeaponToInventory(new Helmet());
        player.addWeaponToInventory(new Whip());
    }

    private void initializePlayers() {
        // Add multiple Player instances with different types to the list
        players.add(new FaeFactory().createPlayer());
        players.add(new MortalFactory().createPlayer());
        players.add(new VampireFactory().createPlayer());
        // Add more players as needed
    }

    private void initializeCharacters() {
        // Add multiple Character instances with different types to the list
        characters.add(new WarriorFactory().createCharacter());
        characters.add(new AssassinFactory().createCharacter());
        characters.add(new ShadowsingerFactory().createCharacter());
        // Add more characters as needed
    }

    public String generateRandomPlayerCharacter() {
        // Randomly select a Player and a Character
        Random random = new Random();
        int playerIndex = random.nextInt(players.size());
        int characterIndex = random.nextInt(characters.size());

        Player randomPlayer = players.get(playerIndex);
        Character randomCharacter = characters.get(characterIndex);

        return "Player Class: " + randomPlayer.getClass().getSimpleName() + "\nPlayer Type: " +
                randomCharacter.getClass().getSimpleName() + "\nHealth: " + randomCharacter.getHealthPoints() + "\nSkills: " + randomCharacter.getDescription();
    }

    private Players player;
    public Inventory getInventory() {
        return player.getInventory();
    }

    public List<Item> getEquippedWeapons() {
        return player.getEquippedWeapons();
    }

    public List<Item> getRecommendedWeapons(Enemy enemy) {
        List<Item> recommendedWeapons = new ArrayList<>();
        if (enemy instanceof SmallEnemy) {
            return getWeaponForSmallEnemy((SmallEnemy) enemy);
        } else if (enemy instanceof MediumEnemy) {
            return getWeaponForMediumEnemy((MediumEnemy) enemy);
        } else if (enemy instanceof BossEnemy) {
            return getWeaponForBoss((BossEnemy) enemy);
        }
        return recommendedWeapons;
    }

    private List<Item> getWeaponForSmallEnemy(SmallEnemy smallEnemy) {
        List<Item> smallRecommendedWeapons = new ArrayList<>();
        if ("Goblin".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Sword());
        } else if ("Zombie".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Dagger());
        } else if ("Baby Dragon".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Crossbow());
        }else if ("Naga".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Helmet());
        }else if ("Hound".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Dagger());
        }else if ("Hugo".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Helmet());
        }else if ("Wrym".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Shield());
        }
        // Add more cases for other types of SmallEnemy...

        // Default case: return the first weapon in the inventory
        return smallRecommendedWeapons;
    }

    private List<Item> getWeaponForMediumEnemy(MediumEnemy mediumEnemy) {
        List<Item> mediumRecommendedWeapons = new ArrayList<>();
        if ("Daemanti".equals(mediumEnemy.getName())) {
            mediumRecommendedWeapons.add(new Helmet());
        } else if ("Griffin".equals(mediumEnemy.getName())) {
            mediumRecommendedWeapons.add(new Sword());
        } else if ("Ghoul Face".equals(mediumEnemy.getName())) {
            mediumRecommendedWeapons.add(new Whip());
        } else if ("Fallen Knight".equals(mediumEnemy.getName())) {
            mediumRecommendedWeapons.add(new Sword());
        } else if ("Witch".equals(mediumEnemy.getName())) {
            mediumRecommendedWeapons.add(new Shield());
        }

        // Add two more weapons from the inventory
        List<Item> inventoryWeapons = player.getInventory().getWeapons();
        mediumRecommendedWeapons.addAll(inventoryWeapons.subList(0, Math.min(2, inventoryWeapons.size())));

        return mediumRecommendedWeapons;
    }
    private List<Item> getWeaponForBoss(BossEnemy bossEnemy) {
        List<Item> bossRecommendedWeapons = new ArrayList<>();
        if ("Fae Lord".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Sword());
        } else if ("Blood Hound".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Sword());
        } else if ("Lindwrym".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Whip());
        }

        // Add two more weapons from the inventory
        List<Item> inventoryWeapons = player.getInventory().getWeapons();
        bossRecommendedWeapons.addAll(inventoryWeapons.subList(0, Math.min(2, inventoryWeapons.size())));

        return bossRecommendedWeapons;
    }

    // Suggest a recommended weapon based on the game logic
    private Item getWeaponFromInventory() {
        // Implement logic to get a weapon from the player's inventory
        // For now, let's assume you have a method like getWeapons() in the player class
        List<Item> weapons = player.getInventory().getWeapons();
        return weapons.isEmpty() ? null : weapons.get(0);
    }

    private static final int SMALL_CHANCE_PERCENTAGE = 10; // Define the small chance percentage

    public void afterBattle() {
        if (shouldTriggerEvent()) {
            // Small chance event occurred
            handleEvent();
        } else {
            // No event occurred
            System.out.println("No special event after this battle.");
        }
    }

    private boolean shouldTriggerEvent() {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Generate a random number between 0 and 100

        return randomNumber < SMALL_CHANCE_PERCENTAGE;
    }

    private void handleEvent() {
        Random random = new Random();
        int eventType = random.nextInt(2); // Randomly choose between chest (0) or shop (1)

        if (eventType == 0) {
            // Chest event
            System.out.println("Found a chest!");
            // Implement logic for generating random items (armor, money, potions) in the chest
        } else {
            // Shop event
            System.out.println("Encountered a shop!");
            // Implement logic for initializing a shop with 3 random objects (weapons, magic scrolls, potions, instant level-up)
        }
    }

    public static void main(String[] args) {
        Main factory = new Main();

        System.out.println();
        System.out.println("Let's begin by selecting a character and its type!");
        System.out.println();
        // Generate and display a random player-character combination
        String randomPlayerCharacter = factory.generateRandomPlayerCharacter();
        System.out.println(randomPlayerCharacter);

        System.out.println();
        System.out.println("...starting game.");
        Main dungeonCrawler = new Main();

        // Example usage for creating enemies based on floors
        for (int i = 1; i <= 40; i++) {
            System.out.println();
            System.out.println("-------Floor " + dungeonCrawler.getCurrentFloor() + "-------");

            // Encountering a monster
            Enemy encounteredEnemy;
            if (i % 10 == 0) {
                BossEnemyFactory bossEnemyFactory = new BossEnemyFactory();
                encounteredEnemy = bossEnemyFactory.createEnemy();
                System.out.println("Encountered a Boss Enemy: ");
                encounteredEnemy.displayInfo();
                // Perform automated battle logic here
            } else if (i % 5 == 0) {
                MediumEnemyFactory mediumEnemyFactory = new MediumEnemyFactory();
                encounteredEnemy = mediumEnemyFactory.createEnemy();
                System.out.println("Encountered a Medium Enemy: ");
                encounteredEnemy.displayInfo();
                // Perform automated battle logic here
            } else {
                SmallEnemyFactory smallEnemyFactory = new SmallEnemyFactory();
                encounteredEnemy = smallEnemyFactory.createEnemy();
                System.out.println("Encountered a Small Enemy: ");
                encounteredEnemy.displayInfo();
                // Perform automated battle logic here
            }

            // Display inventory before encountering a monster
            dungeonCrawler.getInventory().displayWeapons();

            // Let the player automatically pick a weapon based on the monster type
            List<Item> recommendedWeapons = dungeonCrawler.getRecommendedWeapons(encounteredEnemy);
            System.out.println();
            if (!recommendedWeapons.isEmpty()) {
                // Get the first item from the list
                Item recommendedWeapon = recommendedWeapons.get(0);

                // Use recommendedWeapon as needed
                System.out.println("To fight the upcoming monster, it might be best to use a " +
                        recommendedWeapon.getDescription());
                System.out.println("Automatically picked " + recommendedWeapon.getDescription());
            } else {
                // Handle the case when no recommended weapons are available
                System.out.println("No recommended weapons available.");
            }

            // Perform the battle logic here
            List<Item> shopItems = new ArrayList<>();
            shopItems.add(new Sword());
            shopItems.add(new Potion());
            shopItems.add(new Invisibility_Hat());
            shopItems.add(new RarePower());
            shopItems.add(new Spell_Book());
            shopItems.add(new Shield());

            // Create an instance of the shop
            Shop encounteredShop = new BasicShop(shopItems);

            // Check for a small chance of finding a chest or shop
            if (hasSmallChanceEvent()) {
                handleSmallChanceEvent(encounteredShop);
            }

            dungeonCrawler.incrementFloor();
        }
    }


    private static boolean hasSmallChanceEvent() {
        return Math.random() < 0.4;
    }

    private static void handleSmallChanceEvent(Shop encounteredShop) {
        // Randomly choose between chest or shop
        if (Math.random() < 0.5) {
            System.out.println();
            System.out.println("Found a chest!");
            System.out.println("+5 gems!");
            System.out.println();

        } else {
            System.out.println();
            System.out.println("Encountered a shop!");
            System.out.println();
            encounteredShop.displayAvailableItems();

        }

    }
}


