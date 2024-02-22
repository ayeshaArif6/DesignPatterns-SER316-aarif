import static org.junit.Assert.*;

import com.pattern.decorator.*;
import com.pattern.observer.CycleEventObserver;
import com.pattern.observer.HealthEventObserver;
import com.pattern.factory.*;
import com.pattern.factory.Character;
import org.junit.Before;

import org.junit.Test;
import com.pattern.factory.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Tests {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void testDisplayInfoAssassin() {
        Assassin assassin = new Assassin("Test Assassin", 100, "Test Description");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assassin.displayInfo();
        System.setOut(System.out);
        assertTrue(outputStream.toString().contains("This is a Assassin."));
    }


    @Test
    public void testGetNameAssassin() {
        Assassin assassin = new Assassin("Test Assassin", 100, "Test Description");
        assertEquals("Test Assassin", assassin.getName());
    }

    @Test
    public void testGetHealthPointsAssassin() {
        Assassin assassin = new Assassin("Test Assassin", 100, "Test Description");
        assertEquals(100, assassin.getHealthPoints());
    }

    @Test
    public void testGetDescriptionAssassin() {
        Assassin assassin = new Assassin("Test Assassin", 100, "Test Description");
        assertEquals("Test Description", assassin.getDescription());
    }

    @Test
    public void testInitializeAssassin() {
        AssassinFactory assassinFactory = new AssassinFactory();
        List<Character> assassinList = assassinFactory.assassin;
        assertNotNull(assassinList);
        assertFalse(assassinList.isEmpty());
    }

    @Test
    public void testCreateCharacter() {
        AssassinFactory assassinFactory = new AssassinFactory();

        Character character1 = assassinFactory.createCharacter();
        Character character2 = assassinFactory.createCharacter();
        assertTrue(character1 instanceof Assassin);
        assertTrue(character2 instanceof Assassin);
    }

    @Test
    public void testGetBossName() {
        BossEnemy bossEnemy = new BossEnemy("Test Boss", 500, "Terrifying boss");
        assertEquals("Test Boss", bossEnemy.getName());
    }

    @Test
    public void testCreateBossEnemy() {
        BossEnemyFactory bossEnemyFactory = new BossEnemyFactory();

        Enemy enemy1 = bossEnemyFactory.createEnemy();
        Enemy enemy2 = bossEnemyFactory.createEnemy();
        assertTrue(enemy1 instanceof BossEnemy);
        assertTrue(enemy2 instanceof BossEnemy);
    }

    @Test
    public void testBossEnemiesList() {
        BossEnemyFactory bossEnemyFactory = new BossEnemyFactory();

        List<Enemy> bossEnemiesList = bossEnemyFactory.bossEnemies;
        assertNotNull(bossEnemiesList);
        assertFalse(bossEnemiesList.isEmpty());
    }

    @Test
    public void testDisplayInfoFae() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Fae fae = new Fae();

        fae.displayInfo();
        System.setOut(System.out);
        assertTrue(outputStream.toString().contains("This is a Fae."));
    }

    @Test
    public void testGetFaeName() {
        MediumEnemy mediumEnemy = new MediumEnemy("Test Medium", 300, "Testing Medium monster");
        assertEquals("Test Medium", mediumEnemy.getName());
    }
    @Test
    public void testCreateMediumEnemy() {
        MediumEnemyFactory mediumEnemyFactory = new MediumEnemyFactory();
        Enemy enemy1 = mediumEnemyFactory.createEnemy();
        Enemy enemy2 = mediumEnemyFactory.createEnemy();

        assertTrue(enemy1 instanceof MediumEnemy);
        assertTrue(enemy2 instanceof MediumEnemy);
    }

    @Test
    public void testMediumEnemiesList() {
        MediumEnemyFactory mediumEnemyFactory = new MediumEnemyFactory();

        List<Enemy> mediumEnemiesList = mediumEnemyFactory.mediumEnemies;
        assertNotNull(mediumEnemiesList);
        assertFalse(mediumEnemiesList.isEmpty());
    }

    @Test
    public void testDisplayInfoMedium() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        MediumEnemy mediumEnemy = new MediumEnemy("Test Medium Monster", 200, "Test Monster Description");

        mediumEnemy.displayInfo();

        System.setOut(System.out);
        String expectedOutput = "Medium Monster encountered!" +
                System.lineSeparator() +
                "It's a Test Medium Monster!" +
                System.lineSeparator() +
                "Monster health: 200" +
                System.lineSeparator() +
                "Monster description: Test Monster Description" +
                System.lineSeparator() +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDisplayInfoMortal() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Mortal mortal = new Mortal();

        mortal.displayInfo();
        System.setOut(System.out);

        assertTrue(outputStream.toString().contains("This is a Mortal."));
    }

    @Test
    public void testDisplayInfoShadowsinger() {
        Shadowsinger shadowsinger = new Shadowsinger("Test Shadowsinger", 150, "Stealthy assassin");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shadowsinger.displayInfo();

        System.setOut(System.out);
        String expectedOutput = "This is a Shadowsinger named Test Shadowsinger with 150 health points. Description: Stealthy assassin\n";
        assertTrue(outputStream.toString().contains(expectedOutput.trim()));
    }

    @Test
    public void testGetNameShadowsinger() {
        Shadowsinger shadowsinger = new Shadowsinger("Test Shadowsinger", 150, "Stealthy assassin");
        assertEquals("Test Shadowsinger", shadowsinger.getName());
    }

    @Test
    public void testGetHealthPointsShadowsinger() {
        Shadowsinger shadowsinger = new Shadowsinger("Test Shadowsinger", 150, "Stealthy assassin");
        assertEquals(150, shadowsinger.getHealthPoints());
    }

    @Test
    public void testGetDescriptionShadowsinger() {
        Shadowsinger shadowsinger = new Shadowsinger("Test Shadowsinger", 150, "Stealthy assassin");
        assertEquals("Stealthy assassin", shadowsinger.getDescription());
    }

    @Test
    public void testCreateShadowsinger() {
        ShadowsingerFactory shadowsingerFactory = new ShadowsingerFactory();
        Character character1 = shadowsingerFactory.createCharacter();
        Character character2 = shadowsingerFactory.createCharacter();

        assertTrue(character1 instanceof Shadowsinger);
        assertTrue(character2 instanceof Shadowsinger);
    }

    @Test
    public void testCreateSmallEnemy() {
        SmallEnemyFactory smallEnemyFactory = new SmallEnemyFactory();
        Enemy enemy1 = smallEnemyFactory.createEnemy();
        Enemy enemy2 = smallEnemyFactory.createEnemy();

        assertTrue(enemy1 instanceof SmallEnemy);
        assertTrue(enemy2 instanceof SmallEnemy);
    }

    @Test
    public void testSmallEnemiesList() {
        SmallEnemyFactory smallEnemyFactory = new SmallEnemyFactory();

        List<Enemy> smallEnemiesList = smallEnemyFactory.smallEnemies;
        assertNotNull(smallEnemiesList);
        assertFalse(smallEnemiesList.isEmpty());
    }

    @Test
    public void testDisplayInfoSmall() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SmallEnemy smallEnemy = new SmallEnemy("Test Small Monster", 200, "Test Monster Description");

        smallEnemy.displayInfo();

        System.setOut(System.out);
        String expectedOutput = "Small Monster encountered!" +
                System.lineSeparator() +
                "It's a Test Small Monster!" +
                System.lineSeparator() +
                "Monster health: 200" +
                System.lineSeparator() +
                "Monster description: Test Monster Description" +
                System.lineSeparator() +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testDisplayInfoVampire() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Vampire vampire = new Vampire();

        vampire.displayInfo();
        System.setOut(System.out);
        assertTrue(outputStream.toString().contains("This is a Vampire."));
    }

    @Test
    public void testCreateVampire() {
        VampireFactory vampireFactory = new VampireFactory();
        Player player = vampireFactory.createPlayer();

        assertTrue(player instanceof Vampire);
    }

    @Test
    public void testGetWarriorName() {
        Warrior warrior = new Warrior("Test Warrior", 200, "Skilled in close combat");
        assertEquals("Test Warrior", warrior.getName());
    }

    @Test
    public void testGetWarriorHealthPoints() {
        Warrior warrior = new Warrior("Test Warrior", 200, "Skilled in close combat");
        assertEquals(200, warrior.getHealthPoints());
    }

    @Test
    public void testGetWarriorDescription() {
        Warrior warrior = new Warrior("Test Warrior", 200, "Skilled in close combat");
        assertEquals("Skilled in close combat", warrior.getDescription());
    }

    @Test
    public void testDisplayInfoWarrior() {
        Warrior warrior = new Warrior("Test Warrior", 300, "Sword skills");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        warrior.displayInfo();

        System.setOut(System.out);
        String expectedOutput = "This is a Fighter named Test Warrior with 300 health points. Description: Sword skills" +
                System.lineSeparator();
        assertTrue(outputStream.toString().contains(expectedOutput.trim()));
    }

    @Test
    public void testCreateWarrior() {
        WarriorFactory warriorFactory = new WarriorFactory();
        Character character1 = warriorFactory.createCharacter();
        Character character2 = warriorFactory.createCharacter();

        assertTrue(character1 instanceof Warrior);
        assertTrue(character2 instanceof Warrior);
    }

    @Test
    public void getCrossbowDescription() {
        Crossbow crossbow = new Crossbow();

        String description = crossbow.getDescription();
        assertEquals("Crossbow", description);
    }

    @Test
    public void getDaggerDescription() {
        Dagger dagger = new Dagger();
        String description = dagger.getDescription();

        assertEquals("Dagger", description);
    }

    @Test
    public void getHelmetDescription() {
        Helmet helmet = new Helmet();
        String description = helmet.getDescription();

        assertEquals("Helmet", description);
    }

    @Test
    public void getDescription() {
        InstantLevelUpItem instantLevelUpItem = new InstantLevelUpItem();
        String description = instantLevelUpItem.getDescription();

        assertEquals("Instant Level Up", description);
    }

    @Test
    public void addWeapon() {
        Inventory inventory = new Inventory();
        Item weapon = new Dagger();

        inventory.addWeapon(weapon);
        List<Item> weapons = inventory.getWeapons();
        assertEquals(1, weapons.size());
        assertTrue(weapons.contains(weapon));
    }

    @Test
    public void getHatDescription() {
        InvisibilityHat invisibilityHat = new InvisibilityHat();
        String description = invisibilityHat.getDescription();

        assertEquals("Invisibility Hat", description);
    }

    @Test
    public void constructor() {
        Players player = new Players(100);
        Inventory inventory = player.getInventory();
        List<Item> equippedWeapons = player.getEquippedWeapons();

        assertNotNull(inventory);
        assertEquals(1, equippedWeapons.size());
        assertTrue(equippedWeapons.get(0) instanceof Sword);
        assertEquals(100, player.getHealth());
    }

    @Test
    public void equipWeapon() {
        Players player = new Players(100);
        Item weapon = new Dagger();
        player.equipWeapon(weapon);
        List<Item> equippedWeapons = player.getEquippedWeapons();

        assertEquals(2, equippedWeapons.size());
        assertTrue(equippedWeapons.contains(weapon));
    }

    @Test
    public void addWeaponToInventory() {
        Players player = new Players(100);
        Item weapon = new Crossbow();
        player.addWeaponToInventory(weapon);
        List<Item> inventoryWeapons = player.getInventory().getWeapons();

        assertEquals(1, inventoryWeapons.size());
        assertTrue(inventoryWeapons.contains(weapon));
    }


    @Test
    public void decreaseHealth() {
        Players player = new Players(100);
        player.decreaseHealth(Players.EnemyType.SMALL);

        assertEquals(90, player.getHealth());
    }

    @Test
    public void decreaseHealth2() {
        Players player = new Players(20);
        player.decreaseHealth(Players.EnemyType.BOSS);

        assertEquals(0, player.getHealth());
    }

    @Test
    public void getPotionDescription() {
        Potion potion = new Potion();
        String description = potion.getDescription();

        assertEquals("Potion", description);
    }


    @Test
    public void getPowerDescription() {
        RarePower rarePower = new RarePower();
        String description = rarePower.getDescription();

        assertEquals("Rare Power", description);
    }


    @Test
    public void getShieldDescription() {
        Shield shield = new Shield();
        String description = shield.getDescription();

        assertEquals("Shield", description);
    }

    @Test
    public void getSpellDescription() {
        SpellBook spellBook = new SpellBook();
        String description = spellBook.getDescription();

        assertEquals("Spell Book", description);
    }

    @Test
    public void getSwordDescription() {
        Sword sword = new Sword();
        String description = sword.getDescription();

        assertEquals("Sword", description);
    }

    @Test
    public void getWhipDescription() {
        Whip whip = new Whip();
        String description = whip.getDescription();

        assertEquals("Whip", description);
    }



    @Test
    public void testUpdateCycleEvent() {
        CycleEventObserver observer = new CycleEventObserver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        observer.updateCycleEvent(1);
        String printedOutput = outputStream.toString().trim();

        assertEquals("Cycle 1", printedOutput);
    }


    @Test
    public void testUpdateHealthEvent() {

        CycleEventObserver observer = new CycleEventObserver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        observer.updateHealthEvent(100, 75);
        String printedOutput = outputStream.toString().trim();

        assertTrue(printedOutput.isEmpty());
    }

    @Test
    public void testUpdateCycleEvent2() {
        HealthEventObserver observer = new HealthEventObserver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        observer.updateCycleEvent(1);
        String printedOutput = outputStream.toString().trim();

        assertTrue(printedOutput.isEmpty());
    }


    @Test
    public void testCreatePlayer() {
        MortalFactory mortalFactory = new MortalFactory();
        Player player = mortalFactory.createPlayer();

        assertNotNull(player);
        assertTrue(player instanceof Mortal);
    }

    @Test
    public void testCreatePlayerFae() {
        FaeFactory faeFactory = new FaeFactory();
        Player player = faeFactory.createPlayer();
        assertNotNull(player);
        assertTrue(player instanceof Fae);
    }


    @Test
    public void testDisplayInfo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BossEnemy bossEnemy = new BossEnemy("Dragon", 100, "Fire-breathing creature");
        bossEnemy.displayInfo();

        System.setOut(System.out);
        String expectedOutput = "BOSS encountered!" + System.lineSeparator() +
                "It's a Dragon!" + System.lineSeparator() +
                "Monster health: 100" + System.lineSeparator() +
                "Monster description: Fire-breathing creature" + System.lineSeparator() +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
