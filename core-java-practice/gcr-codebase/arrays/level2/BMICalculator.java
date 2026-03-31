package level2;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int personCount = sc.nextInt();

        double[] weights = new double[personCount];
        double[] heights = new double[personCount];
        double[] bmiValues = new double[personCount];
        String[] weightStatus = new String[personCount];

        System.out.println("\n=== Input Data ===");
        for (int i = 0; i < personCount; i++) {
            System.out.printf("\nPerson %d:\n", i + 1);
            
            System.out.print("  Weight (kg): ");
            weights[i] = sc.nextDouble();
            
            System.out.print("  Height (m): ");
            heights[i] = sc.nextDouble();
        }

        for (int i = 0; i < personCount; i++) {
            bmiValues[i] = weights[i] / (heights[i] * heights[i]);
            
            if (bmiValues[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmiValues[i] >= 18.5 && bmiValues[i] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmiValues[i] >= 25.0 && bmiValues[i] <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.println("\n=== BMI Report ===");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n", 
                "Person", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------");
        
        for (int i = 0; i < personCount; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, weights[i], heights[i], bmiValues[i], weightStatus[i]);
        }
    }
}
