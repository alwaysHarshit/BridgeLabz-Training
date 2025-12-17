import java.util.InputMismatchException;
import java.util.Scanner;

public class addTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a, b;

        while (true) {
            try {
                System.out.print("Enter first number: ");
                a = input.nextInt();

                System.out.print("Enter second number: ");
                b = input.nextInt();

                break; // valid input, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid integers only.");
                input.nextLine();
            }
        }


        //calling add function
        int result = add(a, b);
        System.out.println("the result of addition two numbers is :"+result);
    }

    private static int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
