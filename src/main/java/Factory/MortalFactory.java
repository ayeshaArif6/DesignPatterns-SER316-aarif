package Factory;
public class MortalFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Mortal();
    }
}

