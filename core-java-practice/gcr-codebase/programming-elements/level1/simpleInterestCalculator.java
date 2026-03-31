package level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class simpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount;
        double rate;
        double time;

        while(true) {
            try{
                System.out.print("Enter amount in rupees: ");
                amount = sc.nextDouble();

                System.out.print("Enter rate in percentage: ");
                rate = sc.nextDouble();

                System.out.print("Enter time: ");
                time = sc.nextDouble();

                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        double result = siCalculator(amount,rate,time);
        System.out.println("the interest is: " + result);
    }

    private static double siCalculator(double amount, double rate, double time) {
        return amount * (rate/100) * time;
    }
}
