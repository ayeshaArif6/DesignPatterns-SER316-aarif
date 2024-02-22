package Decorator;

//This class implements a potential level up if a player finds a rare level up item in a chest.
public class InstantLevelUpItem implements Item {
    @Override
    public String getDescription() {
        return "Instant Level Up";
    }
}
