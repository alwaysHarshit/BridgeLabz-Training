import java.util.InputMismatchException;
import java.util.Scanner;

public class coffeeCounterChronicles {
    static Scanner sc;
    static final double LATTE_PRICE = 5.0d;
    static final double AMERICANO_PRICE = 8.0d;
    static final double CAPPICCINO_PRICE = 10.0d;


    public static void main(String[] args) {

        sc = new Scanner(System.in);

        while(true){
            System.out.println("Select the coffee type: ");
            System.out.println("1. Latte" );
            System.out.println("2. Cappuccino");
            System.out.println("3. Americano");
            System.out.println("4. Exit");

            System.out.println( "Enter your choice: ");

            int coffeeType = 0;
            try {
                coffeeType = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println( "Please enter a valid number.");
            }

            switch (coffeeType){
                case 1:
                    System.out.println( "Making Latte...");
                    makeCoffee(LATTE_PRICE);
                    break;
                case 2:
                    System.out.println( "Making Cappuccino...");
                    makeCoffee(CAPPICCINO_PRICE);
                    break;
                case 3:
                    System.out.println( "Making Americano...");
                    makeCoffee(AMERICANO_PRICE);
                    break;
                case 4: System.exit(0);
            }
            System.out.println("Please order another coffee?");
        }
    }

    private static void makeCoffee(double price) {
        System.out.println("Enter the number of cups:");
        int cups = sc.nextInt();
        double finalPrice = price * cups * gstPrice(price);

        System.out.printf("Your order is INR %.2f Includes GST.%n", finalPrice);
        System.out.println("Thank you for visiting us.");

    }
    private static double gstPrice(double price) {
        return price + (price * 0.18);
    }
}
