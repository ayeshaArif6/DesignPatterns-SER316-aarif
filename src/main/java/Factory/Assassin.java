package Factory;
public class Assassin implements Character {
    @Override
    public void displayInfo() {
        System.out.println("This is a Assassin.");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getHealthPoints() {
        return 350;
    }

    @Override
    public String getDescription() {
        return "stealth";
    }
}

