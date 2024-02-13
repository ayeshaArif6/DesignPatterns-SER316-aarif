import java.util.Random;
public class Player{

	protected String name;
	public int health;
	public String type;
	public void type() {
		String[] types = {"Mortal","Fae","vampire"};
		Random random = new Random();
		int randomIndex = random.nextInt(types.length);
		name = types[randomIndex];

	}


}
