import java.util.Scanner;

public class maximumOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num1 = getInput(sc, "Enter first number: ");
        int num2 = getInput(sc, "Enter second number: ");
        int num3 = getInput(sc, "Enter third number: ");
        
        int max = findMaximum(num1, num2, num3);
        
        System.out.println("Numbers: " + num1 + ", " + num2 + ", " + num3);
        System.out.println("Maximum: " + max);
    }
    
    public static int getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }
    
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
} 