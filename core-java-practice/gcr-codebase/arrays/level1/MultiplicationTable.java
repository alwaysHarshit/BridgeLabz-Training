package level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] multiplicationResults = new int[10];

        for (int i = 1; i <= 10; i++) {
            multiplicationResults[i - 1] = number * i;
        }

        System.out.printf("\n=== Multiplication Table of %d ===\n\n", number);

        for (int i = 0; i < multiplicationResults.length; i++) {
            System.out.printf("%d * %d = %d\n", number, i + 1, multiplicationResults[i]);
        }
    }
}
