import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continueBooking = true;

        while (continueBooking) {

            int totalAmount = 0;

            //Movie Selection
            System.out.println("\n🎬 Select Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Horror");
            System.out.print("Enter choice: ");
            int movieChoice = sc.nextInt();

            switch (movieChoice) {
                case 1:
                    totalAmount += 200;
                    break;
                case 2:
                    totalAmount += 180;
                    break;
                case 3:
                    totalAmount += 220;
                    break;
                default:
                    System.out.println("Invalid movie choice!");
                    continue;
            }

            //Seat Selection
            System.out.print("\nChoose Seat Type (Gold/Silver): ");
            String seatType = sc.next();

            if (seatType.equalsIgnoreCase("Gold")) {
                totalAmount += 150;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                totalAmount += 100;
            } else {
                System.out.println("Invalid seat type!");
                continue;
            }

            //Snacks Selection
            System.out.print("\nDo you want snacks? (yes/no): ");
            String wantsSnacks = sc.next();

            if (wantsSnacks.equalsIgnoreCase("yes")) {
                System.out.println("🍿 Snacks Menu:");
                System.out.println("1. Popcorn - ₹80");
                System.out.println("2. Cold Drink - ₹60");
                System.out.print("Enter choice: ");
                int snackChoice = sc.nextInt();

                switch (snackChoice) {
                    case 1:
                        totalAmount += 80;
                        break;
                    case 2:
                        totalAmount += 60;
                        break;
                    default:
                        System.out.println("Invalid snack choice!");
                }
            }

            //Final Bill
            System.out.println("\n✅ Booking Successful!");
            System.out.println(" Total Amount: ₹" + totalAmount);

            //Continue or Exit
            System.out.print("\nBook tickets for another customer? (yes/no): ");
            String response = sc.next();

            if (!response.equalsIgnoreCase("yes")) {
                continueBooking = false;
            }
        }

        System.out.println("\n Thank you for using Movie Ticket Booking App!");
    }
}
