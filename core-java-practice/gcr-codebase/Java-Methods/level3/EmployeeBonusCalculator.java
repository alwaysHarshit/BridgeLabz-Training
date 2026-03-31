import java.util.Random;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] employees = new int[10][2]; // [salary, years]
        double[][] results = new double[10][3]; // [old salary, bonus, new salary]
        for (int i = 0; i < 10; i++) {
            employees[i][0] = 10000 + rand.nextInt(90000); // 5-digit salary
            employees[i][1] = 1 + rand.nextInt(10); // 1-10 years
            double bonus = employees[i][1] > 5 ? 0.05 * employees[i][0] : 0.02 * employees[i][0];
            results[i][0] = employees[i][0];
            results[i][1] = bonus;
            results[i][2] = employees[i][0] + bonus;
        }
        double totalOld = 0, totalBonus = 0, totalNew = 0;
        System.out.println("Emp\tSalary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.0f\t%d\t%.2f\t%.2f\n", i+1, results[i][0], employees[i][1], results[i][1], results[i][2]);
            totalOld += results[i][0];
            totalBonus += results[i][1];
            totalNew += results[i][2];
        }
        System.out.printf("Total\t%.0f\t\t%.2f\t%.2f\n", totalOld, totalBonus, totalNew);
    }
}
