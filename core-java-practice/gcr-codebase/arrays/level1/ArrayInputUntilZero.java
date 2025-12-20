package level1;

import java.util.Scanner;

public class ArrayInputUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_SIZE = 10;

        double[] values = new double[MAX_SIZE];
        double total = 0.0;
        int index = 0;

        System.out.println("=== Enter Numbers (max 10, enter 0 or negative to stop) ===\n");

        while (true) {
            System.out.printf("Number %d: ", index + 1);
            double inputValue = sc.nextDouble();

            if (inputValue <= 0) {
                System.out.println("Stopping input (zero or negative number entered).");
                break;
            }

            if (index == 10) {
                System.out.println("Maximum array size reached.");
                break;
            }

            values[index] = inputValue;
            index++;
        }

        System.out.println("\n=== Entered Numbers ===");
        for (int i = 0; i < index; i++) {
            System.out.printf("%.2f ", values[i]);
            total += values[i];
        }

        System.out.printf("\n\n=== Total Sum ===\n%.2f\n", total);
    }
}
