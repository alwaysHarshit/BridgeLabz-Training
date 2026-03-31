import java.util.Scanner;

public class fibonacciSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();
        
        generateFibonacci(terms);
    }
    
    public static void generateFibonacci(int terms) {
        System.out.println("Fibonacci sequence up to " + terms + " terms:");
        
        for (int i = 0; i < terms; i++) {
            System.out.print(calculateFibonacci(i) + " ");
        }
        System.out.println();
    }
    
    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
} 