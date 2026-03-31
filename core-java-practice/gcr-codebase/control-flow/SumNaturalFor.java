import java.util.Scanner;

public class SumNaturalFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;

            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum = loopSum + i;
            }

            System.out.println("Formula sum: " + formulaSum);
            System.out.println("Loop sum: " + loopSum);
            System.out.println("Both results are correct: " + (formulaSum == loopSum));
        }

    }
}
