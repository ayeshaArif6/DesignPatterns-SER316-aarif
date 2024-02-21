package Factory;
public class Shadowsinger implements Character {
    @Override
    public void displayInfo() {
        System.out.println("This is a Thief.");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getHealthPoints() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

