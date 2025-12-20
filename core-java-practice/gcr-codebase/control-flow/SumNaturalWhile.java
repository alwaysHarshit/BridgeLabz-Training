import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;

            int loopSum = 0;
            int counter = 1;
            while (counter <= number) {
                loopSum = loopSum + counter;
                counter++;
            }

            System.out.println("Formula sum: " + formulaSum);
            System.out.println("Loop sum: " + loopSum);
            System.out.println("Both results are correct: " + (formulaSum == loopSum));
        }


    }
}
