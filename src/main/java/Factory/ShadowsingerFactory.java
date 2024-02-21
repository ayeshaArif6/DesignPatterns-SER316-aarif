package Factory;
public class ShadowsingerFactory implements CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Shadowsinger();
    }
}
