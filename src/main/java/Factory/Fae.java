package Factory;

/**
 * This is one of the concrete products for the factory design pattern.
 */
public class Fae implements Player {
    @Override
    public void displayInfo() {
        System.out.println("This is a Fae.");
    }
}
