import java.util.Scanner;

public class bmiFitnessTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your height in meters: ");
        double heightInMeters = scanner.nextDouble();

        System.out.print("Enter your weight in kilograms: ");
        double weightInKg = scanner.nextDouble();
        
        // Calculate BMI
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal";
        } else {
            category = "Overweight";
        }
        

        System.out.printf("Your BMI is %.2f the category: %s%n", bmi, category);
    }
}
