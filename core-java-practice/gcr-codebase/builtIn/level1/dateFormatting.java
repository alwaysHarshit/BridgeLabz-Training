import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dateFormatting {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        System.out.println("Current date in different formats:");
        System.out.println("dd/MM/yyyy: " + currentDate.format(formatter1));
        System.out.println("yyyy-MM-dd: " + currentDate.format(formatter2));
        System.out.println("EEE, MMM dd, yyyy: " + currentDate.format(formatter3));
    }
} 