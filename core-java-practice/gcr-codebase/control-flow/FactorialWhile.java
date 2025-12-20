import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number > 0) {
            int factorial = 1;
            int counter = 1;

            while (counter <= number) {
                factorial = factorial * counter;
                counter++;
            }

            System.out.println(factorial);
        }

    }
}
