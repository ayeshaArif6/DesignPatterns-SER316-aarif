package Factory;
public class FaeFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Fae();
    }
}

