import java.util.InputMismatchException;
import java.util.Scanner;

public class SpookyStory {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean hasWeapon = false;
    public static void main(String[] args) {
        int input = questionBuilder(
        "You are in your house on October 31st when you hear a knock on your door. What do you do?",
        "1) Answer the door", "2) Don't answer the door", "3) Get a weapon");
        if (input == 1) {
            input = questionBuilder(
            "You answer the door. When you open it, you see that nobody is there.",
            "1) Go back inside", "2) Explore outside");
            if (input == 1) {
                input = questionBuilder(
                "After going back inside, you hear the door creak.",
                "1) Check if the door is locked", "2) Ignore it");
                if (input == 1) {
                    input = questionBuilder(
                        "As you walk towards the door, you see a monster in your doorframe.",
                        "1) Run away", "2) Fight it!");
                    if (input == 1) {
                        input = questionBuilder(
                        "Which way do you want go out?",
                        "1) Go out the back door", "2) Go to the window");
                        if (input == 1) {
                            System.out.println("Another monster was waiting when you opened the back door. Unfortunately, you die on this sad Halloween night.");
                            return;
                        } else if (input == 2) {
                            System.out.println("Thankfully you grabbed your weapon! You are able to defeat the monster like a mighty warrior.");
                        }
                    } else if (input == 2) {
                        if (hasWeapon) {
                            System.out.println("Thankfully you grabbed your weapon! You are able to defeat the monster like a mighty warrior.");
                            return;
                        } else {
                            System.out.println("That was stupid. Why did you think you could fistfight a monster? You died.");
                            return;
                        }  
                    }
                } else if (input == 2) {
                    System.out.println("You never even saw what would kill you. You died!");
                    return;
                }
            }
        } else if (input == 2) {

        } else if (input == 3) {
            hasWeapon = true;
            System.out.println("You grab a weapon.");
            main(new String[0]);
        }
    }

    public static int questionBuilder(String question, String... options) {
        while (true) {
            System.out.println(question);
            for (String option : options) {
                System.out.println(option);
            }
            int input = 0;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                continue;
            }
            if (input > options.length || input <= 0) {
                System.out.println("Invalid input.");
                continue;
            } else {
                return input;
            }
        }
    }
}