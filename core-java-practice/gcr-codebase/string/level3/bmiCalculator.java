import java.util.Scanner;
import java.util.Random;

public class bmiCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of persons:");
        int n = sc.nextInt();
        
        double[][] heightWeight = generateRandomData(n);
        String[][] bmiResults = calculateBMI(heightWeight);
        
        displayResults(heightWeight, bmiResults);
    }
    
    public static double[][] generateRandomData(int n) {
        Random random = new Random();
        double[][] data = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            data[i][0] = random.nextDouble() * 100 + 50;
            data[i][1] = random.nextDouble() * 100 + 150;
        }
        
        return data;
    }
    
    public static String[][] calculateBMI(double[][] heightWeight) {
        String[][] results = new String[heightWeight.length][2];
        
        for (int i = 0; i < heightWeight.length; i++) {
            double weight = heightWeight[i][0];
            double heightCm = heightWeight[i][1];
            double heightM = heightCm / 100;
            
            double bmi = weight / (heightM * heightM);
            String status = determineStatus(bmi);
            
            results[i][0] = String.format("%.2f", bmi);
            results[i][1] = status;
        }
        
        return results;
    }
    
    public static String determineStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    
    public static void displayResults(double[][] heightWeight, String[][] bmiResults) {
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------------");
        
        for (int i = 0; i < heightWeight.length; i++) {
            System.out.println((i + 1) + "\t" + String.format("%.1f", heightWeight[i][0]) + 
                             "\t\t" + String.format("%.1f", heightWeight[i][1]) + 
                             "\t\t" + bmiResults[i][0] + "\t\t" + bmiResults[i][1]);
        }
    }
} 