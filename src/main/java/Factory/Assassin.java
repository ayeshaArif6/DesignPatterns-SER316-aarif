package Factory;

/**
 * This is a concrete product for the factory design pattern.
 */
public class Assassin implements Character {

    private String name;
    private int healthPoints;
    private String description;

    public Assassin(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Assassin.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

