import java.util.Scanner;

public class armstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalNumber = sc.nextInt();

        int n = originalNumber;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem * rem;
            n /= 10;
        }
        System.out.println(sum == originalNumber?"Armstrong Number":"Not an Armstrong Number");

    }

    public static class BmiCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your height in cm");
            float height = scanner.nextFloat();

            height /= 100;

            System.out.println("Enter your weight in kg");
            float weight = scanner.nextFloat();

            float bmi = weight / (height * height);

            if (bmi < 18.5) {
                System.out.println("You are underweight");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                System.out.println("You are normal");
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                System.out.println("You are overweight");
            } else {
                System.out.println("You are obese");
            }
        }
    }
}
