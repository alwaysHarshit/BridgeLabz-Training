import java.util.Scanner;

public class LibraryReminderApp {
    final  static int PERDAY_FINE=5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalFine=0;

        for (int book=1;book<=5;book++){
            System.out.println("Enter the return  date of book: "+book);
            int returnDate=scanner.nextInt();

            System.out.println("Enter the due date of book: "+book);
            int dueDate= scanner.nextInt();

            if (returnDate>dueDate){
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;

                System.out.println("⏰ Late by " + lateDays + " days");
                System.out.println("💸 Fine for this book: ₹" + fine);

                totalFine += fine;

            }
            else{
                System.out.println("Returned on time. No fine.");
            }
        }
        System.out.println("\n Total Fine for all books: ₹" + totalFine);
    }
}
