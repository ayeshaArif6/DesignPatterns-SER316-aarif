package Decorator;

/**
 * This class is for the weapon "whip" that implements the item interface.
 */
public class Whip implements Item {
    @Override
    public String getDescription() {
        return "Whip";
    }

}
