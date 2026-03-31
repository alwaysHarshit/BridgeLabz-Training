import java.util.Scanner;

public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        if (delta < 0) {
            return new double[0];
        }
        
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }
        
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[]{root1, root2};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter coefficients for quadratic equation ax² + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        
        double[] roots = findRoots(a, b, c);
        
        if (roots.length == 0) {
            System.out.println("The equation has no real roots.");
        } else if (roots.length == 1) {
            System.out.printf("The equation has one real root: %.2f%n", roots[0]);
        } else {
            System.out.printf("The equation has two real roots: %.2f and %.2f%n", roots[0], roots[1]);
        }
        
        scanner.close();
    }
} 