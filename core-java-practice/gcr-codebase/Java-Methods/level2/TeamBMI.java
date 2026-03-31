import java.util.Scanner;

public class TeamBMI {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal weight";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][3];
        
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter data for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            teamData[i][0] = scanner.nextDouble();
            
            System.out.print("Height (cm): ");
            teamData[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(teamData);
        String[] status = getBMIStatus(teamData);
        
        System.out.println("\nBMI Results:");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n", 
                i + 1, teamData[i][0], teamData[i][1], teamData[i][2], status[i]);
        }
        
        scanner.close();
    }
} 