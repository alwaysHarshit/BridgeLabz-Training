import java.util.Scanner;

public class PowerFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int power = scanner.nextInt();

        if (number > 0 && power > 0) {
            int result = 1;

            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println(result);
        }


    }
}
