import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0.0;

        while (true) {
            double number = scanner.nextDouble();
            if (number <= 0) {
                break;
            }
            total = total + number;
        }

        System.out.println(total);
    }
}
