package level1;

import java.util.Scanner;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index] = i;
                index++;
            }
        }

        System.out.printf("\n=== Factors of %d ===\n", number);
        System.out.print("Factors: ");
        
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i]);
            if (i < index - 1) System.out.print(", ");
        }
        
        System.out.printf("\nTotal factors: %d\n", index);
    }
}
