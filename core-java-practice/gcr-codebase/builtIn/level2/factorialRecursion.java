import java.util.Scanner;

public class factorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        long factorial = calculateFactorial(number);
        displayResult(number, factorial);
    }
    
    public static long calculateFactorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
    
    public static void displayResult(int number, long factorial) {
        if (factorial == -1) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + number + " is: " + factorial);
        }
    }
} 