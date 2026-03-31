import java.util.Scanner;

public class gcdLcmCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);
        
        System.out.println("Numbers: " + num1 + " and " + num2);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }
    
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }
} 