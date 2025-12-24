import java.util.Scanner;

public class NumberAnalyzer {
    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) return 1;
        if (number1 < number2) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        System.out.println("\nAnalysis Results:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + numbers[i] + ": ");
            if (isPositive(numbers[i])) {
                System.out.print("Positive, ");
                System.out.println(isEven(numbers[i]) ? "Even" : "Odd");
            } else {
                System.out.println("Negative");
            }
        }
        
        int comparison = compare(numbers[0], numbers[4]);
        System.out.println("\nComparison of first and last numbers:");
        if (comparison == 1) {
            System.out.println(numbers[0] + " is greater than " + numbers[4]);
        } else if (comparison == -1) {
            System.out.println(numbers[0] + " is less than " + numbers[4]);
        } else {
            System.out.println(numbers[0] + " is equal to " + numbers[4]);
        }
        scanner.close();
    }
} 