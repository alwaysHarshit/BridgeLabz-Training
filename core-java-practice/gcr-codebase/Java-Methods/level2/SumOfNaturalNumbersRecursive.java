import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {
    public static int sumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;
        }
        
        int sumRecursive = sumRecursive(n);
        int sumFormula = sumFormula(n);
        
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);
        
        if (sumRecursive == sumFormula) {
            System.out.println("Both methods give the same result: " + sumRecursive);
        } else {
            System.out.println("Results are different!");
        }
        
        scanner.close();
    }
} 