import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first date (yyyy-MM-dd):");
        String date1Input = sc.nextLine();
        System.out.println("Enter second date (yyyy-MM-dd):");
        String date2Input = sc.nextLine();
        
        LocalDate date1 = LocalDate.parse(date1Input);
        LocalDate date2 = LocalDate.parse(date2Input);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        System.out.println("Date 1: " + date1.format(formatter));
        System.out.println("Date 2: " + date2.format(formatter));
        
        if (date1.isBefore(date2)) {
            System.out.println("Date 1 is before Date 2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date 1 is after Date 2");
        } else if (date1.isEqual(date2)) {
            System.out.println("Date 1 is equal to Date 2");
        }
    }
} 