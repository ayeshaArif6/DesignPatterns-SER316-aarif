package Factory;

public class VampireFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Vampire();
    }
}
