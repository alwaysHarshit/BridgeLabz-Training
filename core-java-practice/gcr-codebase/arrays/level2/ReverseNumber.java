package level2;

import java.util.Scanner;

public class ReverseNumber {
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

        while (tempNumber != 0 || (tempNumber == 0 && index == 0)) {
            digits[index] = (int) (tempNumber % 10);
            tempNumber /= 10;
            index++;
            if (tempNumber == 0) break;
        }

        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }

        System.out.print("\nReversed number: ");
        for (int digit : reversedDigits) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
