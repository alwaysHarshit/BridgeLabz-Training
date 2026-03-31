package level1;

import java.util.Scanner;

public class NumberClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ARRAY_SIZE = 5;
        int[] numbers = new int[ARRAY_SIZE];

        System.out.println("=== Enter 5 Numbers ===\n");

        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.printf("Number %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }

        System.out.println("\n=== Number Analysis ===\n");

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];

            if (value > 0) {
                String parity = (value % 2 == 0) ? "even" : "odd";
                System.out.printf("Number %d: %d is positive and %s\n", i + 1, value, parity);
            } else if (value < 0) {
                System.out.printf("Number %d: %d is negative\n", i + 1, value);
            } else {
                System.out.printf("Number %d: %d is zero\n", i + 1, value);
            }
        }

        System.out.println("\n=== First and Last Element Comparison ===\n");

        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];

        if (firstElement == lastElement) {
            System.out.printf("First element (%d) is equal to last element (%d)\n", firstElement, lastElement);
        } else if (firstElement > lastElement) {
            System.out.printf("First element (%d) is greater than last element (%d)\n", firstElement, lastElement);
        } else {
            System.out.printf("First element (%d) is less than last element (%d)\n", firstElement, lastElement);
        }
    }
}
