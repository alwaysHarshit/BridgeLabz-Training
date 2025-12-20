package level2;

import java.util.Scanner;

public class StudentGradeCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int studentCount = sc.nextInt();

        double[][] marks = new double[studentCount][3];
        double[] percentages = new double[studentCount];
        char[] grades = new char[studentCount];

        System.out.println("\n=== Student Marks Input ===");
        
        int index = 0;
        while (index < studentCount) {
            System.out.printf("\nStudent %d:\n", index + 1);
            
            System.out.print("  Physics marks: ");
            double physics = sc.nextDouble();
            
            System.out.print("  Chemistry marks: ");
            double chemistry = sc.nextDouble();
            
            System.out.print("  Maths marks: ");
            double maths = sc.nextDouble();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("  Invalid! Please enter positive values.");
                index--;
            } else {
                marks[index][0] = physics;
                marks[index][1] = chemistry;
                marks[index][2] = maths;
            }
            index++;
        }

        for (int i = 0; i < studentCount; i++) {
            double totalMarks = 0;
            for (int j = 0; j < 3; j++) {
                totalMarks += marks[i][j];
            }
            
            percentages[i] = (totalMarks / 300) * 100;

            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }

        System.out.println("\n=== Student Grade Report ===");
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-8s%n", 
                "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("----------------------------------------------------------------------");
        
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-12.2f %-8c%n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
