package level2;

import java.util.Scanner;

public class DigitFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        long tempNumber = Math.abs(number);
        int digitCount = 0;

        if (tempNumber == 0) {
            digitCount = 1;
        } else {
            long countTemp = tempNumber;
            while (countTemp != 0) {
                digitCount++;
                countTemp /= 10;
            }
        }

        int[] digits = new int[digitCount];
        int index = 0;

        tempNumber = Math.abs(number);
        
        while (tempNumber != 0 || (tempNumber == 0 && index == 0)) {
            digits[index] = (int) (tempNumber % 10);
            tempNumber /= 10;
            index++;
            if (tempNumber == 0) break;
        }

        int[] frequency = new int[10];

        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\n=== Digit Frequency Report ===");
        System.out.printf("%-10s %-10s%n", "Digit", "Frequency");
        System.out.println("------------------------");
        
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.printf("%-10d %-10d%n", i, frequency[i]);
            }
        }
    }
}
