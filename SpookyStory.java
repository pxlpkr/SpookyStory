/**
 * Project: 1.3: Choose Your Path
 * Authors: Anchal Verma & Axel Parkkila
 * Date: 10/10/2022
 * Course: APCSA 1
 * Description: Recieves user input to create an interactive story.
*/

import java.util.InputMismatchException; //Error for when Scanner.nextInt recieves a non-Integer
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
                        } else {
                            System.out.println("You scramble out of the window and successfully escape. You win!");
                            return;
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
                } else {
                    System.out.println("You never even saw what would kill you. You died!");
                    return;
                }
            } else {
                input = questionBuilder(
                "You hear the door closing behind you.",
                "1) Go to the neighbor's house", "2) Look for your keys under the doormat");
                if (input == 1) {
                    input = questionBuilder(
                    "You walk to your neighbor's house and even though the lights are on, there is no sign of life.",
                    "1) Go in", "2) Go back");
                    if (input == 1) {
                        System.out.println("You go in the house and are horrified by the blood stains covering the ground. When you enter the next room, you find something even worse: the bodies of your neighbor's family piled on top of each other. You realize that whatever caused this might not be far away. As you try to turn back and leave the house, the door opens again and a monster is standing in the doorframe. There is nowhere for you to run. You died a miserable death.");
                        return;
                    } else {
                        System.out.println("You turn around. Turns out, the monster was right behind you. You died!");
                        return;
                    }
                } else {
                    System.out.println("You bend down and raise the doormat, but do not find any keys. Suddenly, you hear somebody behind you. You died on this special Halloween night!");
                    return;
                }
            }
        } else if (input == 2) {
            input = questionBuilder(
            "You ignore the door, but can hear the knocks getting louder.",
            "1) Check the window", "2) Continue not answering the door");
            if (input == 1) {
                System.out.println("You make eye contact with a horrific monster that is waiting outside your door. Petrified, you close the curtains at the same time that they break down the door and attack you. You died!");
                return;
            } else {
                System.out.println("You hear the sound of the door breaking, but you can't react fast enough before the monster gets inside. You died!");
                return;
            }
        } else {
            hasWeapon = true;
            System.out.println("You grab a weapon.");
            main(new String[0]); //Return to beginning of story
        }
    }

    public static int questionBuilder(String question, String... options) {
        System.out.println(question); //Print question to user
        for (String option : options) { //Print all options to user
            System.out.println(option);
        }
        while (true) {
            int input = 0;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) { //Checks to make sure that the input is a number
                System.out.println("Invalid input.");
                continue;
            }
            if (input > options.length || input <= 0) { //Checks to make sure that the input is a valid option
                System.out.println("Invalid input.");
                continue;
            } else {
                return input; //Returns id of option
            }
        }
    }
}