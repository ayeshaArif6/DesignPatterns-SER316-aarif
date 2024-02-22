package Factory;

/**
 * This one of the Concrete products of the factory design pattern.
 */
public class Mortal implements Player {
    @Override
    public void displayInfo() {
        System.out.println("This is a Mortal.");
    }
}

