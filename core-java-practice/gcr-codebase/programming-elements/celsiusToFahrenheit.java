import java.util.InputMismatchException;
import java.util.Scanner;

public class celsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cel;
        while(true) {
            try{
                System.out.print("Enter celsius: ");
                cel = sc.nextDouble();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        double result = conversion(cel);
        System.out.println("the converted degree is:"+result);

    }

    private static double conversion(double cel) {
        return cel * 1.8 + 32;
    }
}
