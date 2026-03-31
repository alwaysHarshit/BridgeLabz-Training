import java.util.Scanner;

public class CheckDivisibilityByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isDivisible = number % 5 == 0;
        System.out.printf("Is the number %d divisible by 5? %s", number, isDivisible);
    }
}
