import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (yyyy-MM-dd):");
        String dateInput = sc.nextLine();
        
        LocalDate date = LocalDate.parse(dateInput);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        System.out.println("Original date: " + date.format(formatter));
        
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, and 2 years: " + result.format(formatter));
        
        LocalDate finalResult = result.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalResult.format(formatter));
    }
} 