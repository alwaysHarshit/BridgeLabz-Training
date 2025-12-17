import java.util.InputMismatchException;
import java.util.Scanner;

public class powerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base, exponent;

        while(true) {
            try{
                System.out.println("Enter base: ");
                base = sc.nextInt();

                System.out.println("Enter exponent: ");
                exponent = sc.nextInt();

                break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        int result = powFunction(base,exponent);
        System.out.println("The result is: " + result);
    }

    private static int powFunction(int base, int exponent) {
        return (int) Math.pow(base,exponent);
    }
}
