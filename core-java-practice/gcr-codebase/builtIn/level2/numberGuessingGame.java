import java.util.Scanner;
import java.util.Random;

public class numberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100");
        System.out.println("I will try to guess it. Tell me if my guess is high, low, or correct.");
        
        int min = 1;
        int max = 100;
        int attempts = 0;
        
        while (true) {
            int guess = generateGuess(min, max);
            attempts++;
            
            System.out.println("\nMy guess: " + guess);
            String feedback = getUserFeedback(sc);
            
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Great! I guessed your number in " + attempts + " attempts!");
                break;
            } else if (feedback.equalsIgnoreCase("high")) {
                max = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                min = guess + 1;
            }
            
            if (min > max) {
                System.out.println("Something went wrong with the feedback!");
                break;
            }
        }
    }
    
    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    public static String getUserFeedback(Scanner sc) {
        System.out.print("Is my guess high, low, or correct? ");
        return sc.nextLine();
    }
} 