import java.util.Random;

public class Class extends Player{

    public String name;
    public int strength;
    public String specialAbility;

    public void randomClass(){
        String[] classes = {"Illyrian Warrior", "Shadowsinger", "Assassin"};
        Random random = new Random();
        int randomIndex = random.nextInt(classes.length);
        name = classes[randomIndex];
        classDetails();

    }

    public void classDetails(){
        if (name.equals("Illyrian Warriors")) {
            strength = 500;
            specialAbility = "Has wings";
        }
        else if (name.equals("Shadowsinger")) {
            strength = 400;
            specialAbility = "Can control shadows";
        }
        else {
            strength = 250;
            specialAbility = "Increased stealth and precision";
        }
    }

}
