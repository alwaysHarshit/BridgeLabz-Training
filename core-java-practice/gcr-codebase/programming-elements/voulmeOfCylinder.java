import java.util.InputMismatchException;
import java.util.Scanner;

public class voulmeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius,height;
        while(true) {
            try{
                System.out.print("Enter radius: ");
                radius = sc.nextDouble();

                System.out.print("Enter height: ");
                height = sc.nextDouble();

                break;
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a number");
                sc.nextLine();
            }
        }
        double result=area(radius,height);
        System.out.println("the area of the cylinder is "+result);
    }

    private static double area(double radius, double height) {
        return Math.PI*Math.pow(radius,2)*height;
    }
}
