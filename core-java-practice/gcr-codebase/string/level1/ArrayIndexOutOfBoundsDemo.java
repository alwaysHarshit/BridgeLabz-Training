package level1;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        String[] names = new String[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.println("\n=== Generating ArrayIndexOutOfBoundsException ===");
        // generateException(names);  // Uncomment to see the exception

        System.out.println("\n=== Handling ArrayIndexOutOfBoundsException ===");
        handleException(names);
    }

    private static void generateException(String[] names) {
        System.out.println("Accessing index beyond length: " + names[names.length + 5]);
    }

    private static void handleException(String[] names) {
        try {
            System.out.println("Accessing index beyond length: " + names[names.length + 5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
            System.out.println("Index is out of bounds for the array.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
