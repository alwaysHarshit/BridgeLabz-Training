package level1;

import java.util.Scanner;

public class MultiplicationTable6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] multiplicationResult = new int[4];

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        System.out.printf("\n=== Multiplication Table of %d (6 to 9) ===\n\n", number);

        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.printf("%d * %d = %d\n", number, i + 6, multiplicationResult[i]);
        }
    }
}
