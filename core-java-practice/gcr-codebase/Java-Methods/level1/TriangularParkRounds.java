import java.util.Scanner;

public class TriangularParkRounds {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceInMeters = 5000;
        return distanceInMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first side (in meters): ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter second side (in meters): ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter third side (in meters): ");
        double side3 = scanner.nextDouble();
        
        double rounds = calculateRounds(side1, side2, side3);
        
        System.out.printf("Number of rounds needed to complete 5km: %.2f", rounds);
        
        scanner.close();
    }
} 