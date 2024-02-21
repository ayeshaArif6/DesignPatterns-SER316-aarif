package Factory;
public class AssassinFactory implements CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Assassin();
    }
}


