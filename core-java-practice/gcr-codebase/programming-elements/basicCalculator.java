import java.util.Scanner;

public class basicCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();


        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();

        double addition = firstNumber + secondNumber;
        double subtraction = firstNumber - secondNumber;
        double multiplication = firstNumber * secondNumber;
        double division = firstNumber / secondNumber;
        System.out.println("the result of addition, subtraction, multiplication and division is:"+addition+","+subtraction+","+multiplication+","+division);
    }
}


