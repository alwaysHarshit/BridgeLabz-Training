import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary = scanner.nextDouble();
        int year = scanner.nextInt();

        double bonus = 0;

        if (year > 5) {
            bonus = salary * 0.05;
        }

        System.out.println(bonus);

    }
}
