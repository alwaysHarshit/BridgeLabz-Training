package level1;

import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (positive integer).");
            return;
        }

        int arraySize = number / 2 + 1;
        int[] oddNumbers = new int[arraySize];
        int[] evenNumbers = new int[arraySize];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.println("\n=== Results ===");

        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i]);
            if (i < oddIndex - 1) System.out.print(", ");
        }

        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i]);
            if (i < evenIndex - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
