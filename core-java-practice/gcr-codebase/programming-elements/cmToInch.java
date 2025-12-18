import java.util.Scanner;

public class cmToInch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter height in cm: ");
        double a = s.nextDouble();
        double b = a / 2.54;
        int c = (int)(b / 12);
        double d = b - (c * 12);
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", a, c, d);
    }
}