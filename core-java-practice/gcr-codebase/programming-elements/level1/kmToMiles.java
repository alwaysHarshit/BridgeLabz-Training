package level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class kmToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km;
        while(true) {
            try{
                System.out.println("Enter the kilometers: ");
                km = sc.nextDouble();

                break;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        double miles =kmtoMiles(km);
        System.out.println("the miles in kilometers is: " + miles);
    }

    private static double kmtoMiles(double km) {
        return km * 0.621371;
    }
}
