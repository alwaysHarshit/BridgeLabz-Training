package level1;

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("\n=== Generating StringIndexOutOfBoundsException ===");
        // generateException(text);  // Uncomment to see the exception

        System.out.println("\n=== Handling StringIndexOutOfBoundsException ===");
        handleException(text);
    }

    private static void generateException(String text) {
        System.out.println("Accessing index beyond length: " + text.charAt(text.length() + 5));
    }

    private static void handleException(String text) {
        try {
            System.out.println("Accessing index beyond length: " + text.charAt(text.length() + 5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
            System.out.println("Index is out of bounds for the string.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
