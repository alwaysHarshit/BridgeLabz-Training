package level2;

import java.util.Scanner;

public class DynamicDigitArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        long tempNumber = Math.abs(number);

        while (tempNumber != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                
                digits = temp;
            }

            digits[index] = (int) (tempNumber % 10);
            tempNumber /= 10;
            index++;
        }

        if (index == 0) {
            System.out.println("No digits to process.");
            return;
        }

        int largestDigit = 0;
        int secondLargestDigit = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digits[i];
            } else if (digits[i] > secondLargestDigit && digits[i] != largestDigit) {
                secondLargestDigit = digits[i];
            }
        }

        System.out.println("\n=== Results ===");
        System.out.printf("Total digits processed: %d\n", index);
        System.out.printf("Largest digit: %d\n", largestDigit);
        
        if (secondLargestDigit == 0 && index > 1) {
            System.out.println("Second largest digit: 0");
        } else if (index == 1) {
            System.out.println("Second largest digit: Not available (only one digit)");
        } else {
            System.out.printf("Second largest digit: %d\n", secondLargestDigit);
        }
    }
}
