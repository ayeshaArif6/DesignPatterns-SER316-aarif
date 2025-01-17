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
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Tests {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateAssassinCharacter() {
        AssassinFactory assassinFactory = new AssassinFactory();

        Character character1 = assassinFactory.createCharacter();
        Character character2 = assassinFactory.createCharacter();

        assertNotNull("Character 1 should not be null", character1);
        assertNotNull("Character 2 should not be null", character2);

        assertTrue("Character 1 should be an instance of Assassin", character1 instanceof Assassin);
        assertTrue("Character 2 should be an instance of Assassin", character2 instanceof Assassin);

        Assassin assassin1 = (Assassin) character1;
        Assassin assassin2 = (Assassin) character2;
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

        assertNotNull("Character1 should not be null", character1);
        assertNotNull("Character2 should not be null", character2);

        assertTrue("Character1 should be an instance of Assassin", character1 instanceof Assassin);
        assertTrue("Character2 should be an instance of Assassin", character2 instanceof Assassin);
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

        assertNotNull("Enemy1 should not be null", enemy1);
        assertNotNull("Enemy2 should not be null", enemy2);

        assertTrue("Enemy1 should be an instance of BossEnemy", enemy1 instanceof BossEnemy);
        assertTrue("Enemy2 should be an instance of BossEnemy", enemy2 instanceof BossEnemy);

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
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            Fae fae = new Fae();
            fae.displayInfo();

            System.setOut(System.out);

            String output = outputStream.toString("UTF-8");

            assertTrue(output.contains("This is a Fae."));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
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

        assertNotNull("Enemy1 should not be null", enemy1);
        assertNotNull("Enemy2 should not be null", enemy2);

        assertTrue("Enemy1 should be an instance of MediumEnemy", enemy1 instanceof MediumEnemy);
        assertTrue("Enemy2 should be an instance of MediumEnemy", enemy2 instanceof MediumEnemy);


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
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            MediumEnemy mediumEnemy = new MediumEnemy("Test Medium Monster", 200, "Test Monster Description");
            mediumEnemy.displayInfo();

            System.setOut(System.out);

            // Explicitly specify the character encoding
            String expectedOutput = "Medium Monster encountered!" +
                    System.lineSeparator() +
                    "It's a Test Medium Monster!" +
                    System.lineSeparator() +
                    "Monster health: 200" +
                    System.lineSeparator() +
                    "Monster description: Test Monster Description" +
                    System.lineSeparator() +
                    System.lineSeparator();

            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }


    @Test
    public void testDisplayInfoMortal() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            Mortal mortal = new Mortal();
            mortal.displayInfo();

            System.setOut(System.out);

            assertTrue(outputStream.toString("UTF-8").contains("This is a Mortal."));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }

    @Test
    public void testDisplayInfoShadowsinger() {
        Shadowsinger shadowsinger = new Shadowsinger("Test Shadowsinger", 150, "Stealthy assassin");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            shadowsinger.displayInfo();

            System.setOut(System.out);
            String expectedOutput = "This is a Shadowsinger named Test Shadowsinger with 150 health points. Description: Stealthy assassin\n";

            assertTrue(outputStream.toString("UTF-8").contains(expectedOutput.trim()));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
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

        assertNotNull("Enemy1 should not be null", enemy1);
        assertNotNull("Enemy2 should not be null", enemy2);

        assertTrue("Enemy1 should be an instance of SmallEnemy", enemy1 instanceof SmallEnemy);
        assertTrue("Enemy2 should be an instance of SmallEnemy", enemy2 instanceof SmallEnemy);

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
        SmallEnemy smallEnemy = new SmallEnemy("Test Small Monster", 200, "Test Monster Description");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

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

            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }


    @Test
    public void testDisplayInfoVampire() {
        Vampire vampire = new Vampire();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            vampire.displayInfo();

            System.setOut(System.out);
            String expectedOutput = "This is a Vampire." + System.lineSeparator();

            // Explicitly specify the character encoding
            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }

    @Test
    public void testCreateVampire() {
        VampireFactory vampireFactory = new VampireFactory();
        Player player = vampireFactory.createPlayer();

        assertNotNull("Player should not be null", player);
        assertTrue("Player should be an instance of Vampire", player instanceof Vampire);

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
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            warrior.displayInfo();

            System.setOut(System.out);
            String expectedOutput = "This is a Fighter named Test Warrior with 300 health points. Description: Sword skills"
                    + System.lineSeparator();

            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }

    @Test
    public void testCreateWarrior() {
        WarriorFactory warriorFactory = new WarriorFactory();
        Character character1 = warriorFactory.createCharacter();
        Character character2 = warriorFactory.createCharacter();

        assertNotNull("Character 1 should not be null", character1);
        assertNotNull("Character 2 should not be null", character2);

        assertTrue("Character 1 should be an instance of Warrior", character1 instanceof Warrior);
        assertTrue("Character 2 should be an instance of Warrior", character2 instanceof Warrior);

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
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            observer.updateCycleEvent(1);
            String printedOutput = outputStream.toString("UTF-8").trim();

            assertEquals("Cycle 1", printedOutput);
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }


    @Test
    public void testUpdateHealthEvent() {
        CycleEventObserver observer = new CycleEventObserver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            observer.updateHealthEvent(100, 75);
            String printedOutput = outputStream.toString("UTF-8").trim();

            assertTrue(printedOutput.isEmpty());
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateCycleEvent2() {
        HealthEventObserver observer = new HealthEventObserver();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            observer.updateCycleEvent(1);
            String printedOutput = outputStream.toString("UTF-8").trim();

            assertTrue(printedOutput.isEmpty());
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
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

        assertNotNull("Player should not be null", player);
        assertTrue("Player should be an instance of Fae", player instanceof Fae);
    }


    @Test
    public void testDisplayInfo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")) {
            System.setOut(printStream);

            BossEnemy bossEnemy = new BossEnemy("Dragon", 100, "Fire-breathing creature");
            bossEnemy.displayInfo();

            System.setOut(System.out);
            String expectedOutput = "BOSS encountered!" + System.lineSeparator() +
                    "It's a Dragon!" + System.lineSeparator() +
                    "Monster health: 100" + System.lineSeparator() +
                    "Monster description: Fire-breathing creature" + System.lineSeparator() +
                    System.lineSeparator();

            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            fail("Unsupported encoding: " + e.getMessage());
        }
    }

}
