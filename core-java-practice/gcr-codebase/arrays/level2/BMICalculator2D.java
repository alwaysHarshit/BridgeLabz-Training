package level2;

import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        System.out.println("\n=== Input Data ===");
        int index = 0;
        while (index < number) {
            System.out.printf("\nPerson %d:\n", index + 1);
            
            System.out.print("  Weight (kg): ");
            double weight = sc.nextDouble();
            
            System.out.print("  Height (m): ");
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("  Invalid! Please enter positive values.");
                index--;
            } else {
                personData[index][0] = weight;
                personData[index][1] = height;
            }
            index++;
        }

        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            double bmi = weight / (height * height);
            
            personData[i][2] = bmi;
            
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25.0 && bmi <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.println("\n=== BMI Report ===");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n", 
                "Person", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------");
        
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
