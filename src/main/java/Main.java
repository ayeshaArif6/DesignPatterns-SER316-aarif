import java.util.ArrayList;
import java.util.List;
import com.pattern.factory.*;
import com.pattern.factory.*;
import com.pattern.decorator.*;
import com.pattern.observer.CycleEventObserver;
import com.pattern.observer.GameManager;
import com.pattern.observer.*;
import com.pattern.decorator.*;
import com.pattern.factory.Character;
import com.pattern.observer.Observer;

import java.util.Random;
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

    //This si the constructor for the Main class.
    public Main() {
        players = new ArrayList<>();
        initializePlayers(); // This initializes the list with player instances

        characters = new ArrayList<>();
        initializeCharacters(); // This initializes the list with character instances

        this.currentFloor = 1;
        this.player = new Players(700);
        player.addWeaponToInventory(new Sword());
        player.addWeaponToInventory(new Shield());
        player.addWeaponToInventory(new Dagger());
        player.addWeaponToInventory(new Crossbow());
        player.addWeaponToInventory(new Helmet());
        player.addWeaponToInventory(new Whip());
    }

    /**
     * This initializes players of different types.
     */
    private void initializePlayers() {
        players.add(new FaeFactory().createPlayer());
        players.add(new MortalFactory().createPlayer());
        players.add(new VampireFactory().createPlayer());
    }

    /**
     * This adds new characters and initializes them.
     */
    private void initializeCharacters() {
        characters.add(new WarriorFactory().createCharacter());
        characters.add(new AssassinFactory().createCharacter());
        characters.add(new ShadowsingerFactory().createCharacter());
    }

    /**
     * This method randomly selects a Player type and a Character type
     * @return String with player information.
     */
    public String generateRandomPlayerCharacter() {
        Random random = new Random();
        int playerIndex = random.nextInt(players.size());
        int characterIndex = random.nextInt(characters.size());

        Player randomPlayer = players.get(playerIndex);
        Character randomCharacter = characters.get(characterIndex);

        return "Player Class: " + randomPlayer.getClass().getSimpleName() + "\nPlayer Type: " +
                randomCharacter.getClass().getSimpleName() + "\nHealth: " + randomCharacter.getHealthPoints() + "\nSkills: " + randomCharacter.getDescription();
    }

    private static Players player;
    public Inventory getInventory() {
        return player.getInventory();
    }

    public List<Item> getEquippedWeapons() {
        return player.getEquippedWeapons();
    }

    /**
     * This method gets the recommended weapon depending on which monster or enemy is encountered.
     * @param enemy
     * @return List of recommended weapons.
     */

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

    /**
     * This method sets the recommended weapon for small sized monsters since this is an
     * automated game.
     * @param smallEnemy
     * @return
     */
    private List<Item> getWeaponForSmallEnemy(SmallEnemy smallEnemy) {
        List<Item> smallRecommendedWeapons = new ArrayList<>();
        if ("Goblin".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Sword());
        } else if ("Zombie".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Dagger());
        } else if ("Baby Dragon".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Crossbow());
        } else if ("Naga".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Helmet());
        } else if ("Hound".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Dagger());
        } else if ("Hugo".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Helmet());
        } else if ("Wrym".equals(smallEnemy.getName())) {
            smallRecommendedWeapons.add(new Shield());
        }
        return smallRecommendedWeapons;
    }

    /**
     * This method sets the recommended weapon for medium-sized monsters in the automated game.
     * @param mediumEnemy
     * @return
     */
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

        // Add two more weapons from the inventory since player can wield three at a time.
        List<Item> inventoryWeapons = player.getInventory().getWeapons();
        mediumRecommendedWeapons.addAll(inventoryWeapons.subList(0, Math.min(2, inventoryWeapons.size())));

        return mediumRecommendedWeapons;
    }


    /**
     * This method sets the recommended weapon for BOSS monsters in automated game.
     * @param bossEnemy
     * @return
     */
    private List<Item> getWeaponForBoss(BossEnemy bossEnemy) {
        List<Item> bossRecommendedWeapons = new ArrayList<>();
        if ("Fae Lord".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Sword());
        } else if ("Blood Hound".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Sword());
        } else if ("Lindwrym".equals(bossEnemy.getName())) {
            bossRecommendedWeapons.add(new Whip());
        }

        List<Item> inventoryWeapons = player.getInventory().getWeapons();
        bossRecommendedWeapons.addAll(inventoryWeapons.subList(0, Math.min(2, inventoryWeapons.size())));

        return bossRecommendedWeapons;
    }


    /**
     * This method determines enemy type based on what floor the player is on.
     * @param floorNumber
     * @return
     */
    public static Players.EnemyType determineEnemyType(int floorNumber) {
        if (floorNumber % 10 == 0) {
            return Players.EnemyType.BOSS;
        } else if (floorNumber % 5 == 0) {
            return Players.EnemyType.MEDIUM;
        } else {
            return Players.EnemyType.SMALL;
        }
    }


    public static void main(String[] args) {
        Main factory = new Main();

        System.out.println();
        System.out.println("----------==========Background==========------------");
        System.out.println();
        System.out.println("This is a text-based automated RPG Dungeon Crawler game that is influenced by the" +
                " famous novel series 'A Court Of Thorns And Roses' better known as ACOTAR");
        System.out.println("The player types used in this game such as Mortal, Fae, and Vampire are based off" +
                " of the main characters in these books. The Character types used such as Assassin, Shdowsinger," +
                " and Warrior are also from the the story line ");
        System.out.println("The game starts off at level 1 and finishes at the dungeons in level 40. Small-sized monsters, " +
                "medium-sized monsters and BOSS monsters all await in these dark depths. ");
        System.out.println();
        System.out.println("Some useful vocabulary:");
        System.out.println("1. Shadowsinger: A mythical being that can control shadows and turn into shadow as well.");
        System.out.println("2. Fae: An ancient type of fairy. Not the cute ones with wings but rather they are vicious," +
                " blood-thirsty, and cruel.");
        System.out.println();
        System.out.println();
        System.out.println("Let's begin by selecting a character and its type!");
        System.out.println();

        // This generates and displays a random player-character combination
        String randomPlayerCharacter = factory.generateRandomPlayerCharacter();
        System.out.println(randomPlayerCharacter);

        System.out.println();
        System.out.println("...starting game.");
        Main dungeonCrawler = new Main();
        GameManager gameManager = new GameManager();

        Observer cycleEventObserver = new CycleEventObserver();
        gameManager.addObserver(cycleEventObserver);


        for (int i = 1; i <= 40; i++) {
            System.out.println();
            System.out.println("-------Floor " + dungeonCrawler.getCurrentFloor() + "-------");

            if (i % 16 == 1) {
                int cycleNumber = (i - 1) / 16 + 1;
                System.out.println("Start of Cycle " + cycleNumber);
                gameManager.notifyObserversCycleEvent(cycleNumber);
            }

            // This determines the current part of the cycle
            int partNumber = ((i - 1) % 16) / 4 + 1;
            System.out.println("Part Q" + partNumber);


            // Loops for dealing with encountering enemies
            Enemy encounteredEnemy;
            if (i % 10 == 0) {
                BossEnemyFactory bossEnemyFactory = new BossEnemyFactory();
                encounteredEnemy = bossEnemyFactory.createEnemy();
                System.out.println("Encountered a Boss Enemy: ");
                encounteredEnemy.displayInfo();

            } else if (i % 5 == 0) {
                MediumEnemyFactory mediumEnemyFactory = new MediumEnemyFactory();
                encounteredEnemy = mediumEnemyFactory.createEnemy();
                System.out.println("Encountered a Medium Enemy: ");
                encounteredEnemy.displayInfo();

            } else {
                SmallEnemyFactory smallEnemyFactory = new SmallEnemyFactory();
                encounteredEnemy = smallEnemyFactory.createEnemy();
                System.out.println("Encountered a Small Enemy: ");
                encounteredEnemy.displayInfo();

            }

           // This displays the weapon inventory before the battle commences with the enemy.
            dungeonCrawler.getInventory().displayWeapons();

            // Since the game is automated, this lets the player automatically pick a weapon based on the enemy type
            List<Item> recommendedWeapons = dungeonCrawler.getRecommendedWeapons(encounteredEnemy);
            System.out.println();
            if (!recommendedWeapons.isEmpty()) {
                Item recommendedWeapon = recommendedWeapons.get(0);

                System.out.println("To fight the upcoming monster, it might be best to use a " +
                        recommendedWeapon.getDescription());
                System.out.println("Automatically picked " + recommendedWeapon.getDescription());
            } else {
                // Handles the case when no recommended weapons are available
                System.out.println("No recommended weapons available.");
            }

            System.out.println();
            System.out.println("Start Battle!");
            System.out.println();
            System.out.println("Nice work! Now go for the kill!");
            System.out.println("You took down the monster! Let's go!");
            System.out.println();
            int currentFloor = dungeonCrawler.getCurrentFloor();
            Players.EnemyType enemyType = determineEnemyType(currentFloor);
            player.decreaseHealth(enemyType);

            int damage = player.calculateDamage(enemyType);
            int playerHealth = player.getHealth();
            System.out.println("Player Health: " + playerHealth);
            System.out.println("Damage sustained: " + damage);

            List<Item> shopItems = new ArrayList<>();
            shopItems.add(new Sword());
            shopItems.add(new Potion());
            shopItems.add(new InvisibilityHat());
            shopItems.add(new RarePower());
            shopItems.add(new SpellBook());
            shopItems.add(new Shield());

            // This creates an instance of the shop
            Shop encounteredShop = new BasicShop(shopItems);

            // This checks for a small chance of finding a chest or shop
            if (hasSmallChanceEvent()) {
                handleSmallChanceEvent(encounteredShop, partNumber);
            }

            //This keeps track of which part and cycle the floor is currently part of
            if (i % 16 == 0) {
                int cycleNumber = i / 16;
                System.out.println("End of Cycle " + cycleNumber);
                gameManager.notifyObserversCycleEvent(cycleNumber);
            }

            System.out.println();
            System.out.println("....Advancing to next floor\n");
            dungeonCrawler.incrementFloor();
        }
    }


    /**
     * This calculates a percentage of displaying a chest or a shop on different floors.
     * @return
     */
    private static boolean hasSmallChanceEvent() {
        return Math.random() < 0.4;
    }

    /**
     * This method chooses between a shop and a chest to display randomly.
     * @param encounteredShop
     * @param partNumber
     */
    private static void handleSmallChanceEvent(Shop encounteredShop, int partNumber) {
        if (Math.random() < 0.5) {
            System.out.println();
            System.out.println("Found a chest!");
                if (partNumber == 1 || partNumber == 3) {
                    System.out.println("+5 gems!");
                    System.out.println("+10 gold coins!");
                }
                else {
                    System.out.println("+5 gems!");
                }

        } else {
            System.out.println();
            System.out.println("Encountered a shop!");
            System.out.println();
            encounteredShop.displayAvailableItems();

        }

    }
}


