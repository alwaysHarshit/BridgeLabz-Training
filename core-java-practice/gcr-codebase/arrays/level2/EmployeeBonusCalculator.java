package level2;

import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;

        double[][] employeeData = new double[EMPLOYEE_COUNT][2];
        double[] bonusAmount = new double[EMPLOYEE_COUNT];
        double[] updatedSalary = new double[EMPLOYEE_COUNT];

        double totalBonusPayout = 0;
        double totalCurrentSalary = 0;
        double totalUpdatedSalary = 0;

        System.out.println("=== Zara Employee Bonus Calculator ===\n");

        int index = 0;
        while (index < EMPLOYEE_COUNT) {
            System.out.printf("Employee %d:\n", index + 1);

            System.out.print("  Enter salary: ");
            double salary = sc.nextDouble();

            System.out.print("  Enter years of service: ");
            double yearsOfService = sc.nextDouble();

            if (salary <= 0 || yearsOfService < 0) {
                System.out.println("  Invalid input! Please enter positive values.\n");
                index--;
            } else {
                employeeData[index][0] = salary;
                employeeData[index][1] = yearsOfService;
            }
            index++;
        }

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double currentSalary = employeeData[i][0];
            double serviceYears = employeeData[i][1];

            double bonusPercentage = (serviceYears > 5) ? 0.05 : 0.02;
            double bonus = currentSalary * bonusPercentage;

            bonusAmount[i] = bonus;
            updatedSalary[i] = currentSalary + bonus;

            totalBonusPayout += bonus;
            totalCurrentSalary += currentSalary;
            totalUpdatedSalary += updatedSalary[i];
        }

        System.out.println("\n=== Salary Summary ===");
        System.out.printf("Total Old Salary: %.2f\n", totalCurrentSalary);
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonusPayout);
        System.out.printf("Total New Salary: %.2f\n", totalUpdatedSalary);

        System.out.println("\n=== Individual Breakdown ===");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d | Old: %.2f | Bonus: %.2f | New: %.2f\n",
                    i + 1, employeeData[i][0], bonusAmount[i], updatedSalary[i]);
        }
    }
}
