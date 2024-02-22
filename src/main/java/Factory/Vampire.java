package Factory;

/**
 * This is one of the concrete products for the factory design pattern.
 */
public class Vampire implements Player {
    @Override
    public void displayInfo() {
        System.out.println("This is a Vampire.");
    }
}
