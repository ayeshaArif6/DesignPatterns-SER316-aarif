public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome!");
        System.out.println();
        System.out.println(".........Starting new game");
        System.out.println();
        System.out.println("Let's begin by choosing a character");
        System.out.println("Character chosen:");
        Class character = new Class();
        character.randomClass();
        System.out.println("Class: " + character.name);
        System.out.println("Strength: " + character.strength);
        System.out.println("Special Ability: " + character.specialAbility);
    }
}
