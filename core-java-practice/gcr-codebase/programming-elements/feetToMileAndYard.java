import java.util.Scanner;

public class feetToMileAndYard {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double a = s.nextDouble();
        double b = a / 3;
        double c = b / 1760;
        double d = b - (c * 1760);
        System.out.printf("Your distance in feet is %.2f while in miles is %f and yards is %.2f%n", a, c, d);
        s.close();
    }
}