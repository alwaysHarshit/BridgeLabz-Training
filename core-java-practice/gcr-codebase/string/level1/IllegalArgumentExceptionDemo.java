package level1;

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("\n=== Generating IllegalArgumentException ===");
        // generateException(text);  // Uncomment to see the exception

        System.out.println("\n=== Handling IllegalArgumentException ===");
        handleException(text);
    }

    private static void generateException(String text) {
        System.out.println("Substring with invalid indices: " + text.substring(5, 2));
    }

    private static void handleException(String text) {
        try {
            System.out.println("Substring with invalid indices: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
            System.out.println("Start index is greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
