import java.util.Scanner;

public class SumUntilZeroWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0.0;
        double number = scanner.nextDouble();

        while (number != 0) {
            total = total + number;
            number = scanner.nextDouble();
        }

        System.out.println(total);
    }
}
