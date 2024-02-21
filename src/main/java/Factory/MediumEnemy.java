package Factory;
public class MediumEnemy implements Enemy {
    private String name;
    private int healthPoints;
    private String description;

    public MediumEnemy(String name, int healthPoints, String description) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
    }

    @Override
    public void displayInfo() {
        System.out.println("Medium Monster encountered!");
        System.out.println("It's a " + name + "!");
        System.out.println("Monster health: " + healthPoints);
        System.out.println("Monster description: " + description);
        System.out.println();
    }

    public String getName(){
        return name;
    }
}
