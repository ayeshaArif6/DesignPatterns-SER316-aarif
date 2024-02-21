package Factory;
public class SmallEnemy implements Enemy {
    public String name;
    private int healthPoints;
    private String description;

    public SmallEnemy(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
    }

    @Override
    public void displayInfo() {
        System.out.println("Small Monster encountered!");
        System.out.println("It's a " + name + "!");
        System.out.println("Monster health: " + healthPoints);
        System.out.println("Monster description: " + description);
        System.out.println();
    }

    public String getName(){
        return name;
    }
}
