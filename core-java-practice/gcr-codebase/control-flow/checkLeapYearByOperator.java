import java.util.Scanner;

public class checkLeapYearByOperator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year;
        while (true){
            year = sc.nextInt();
            if(year >= 1582) break;
            System.out.println("Please enter a valid year after 1582");
        }

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("the year "+ year+(isLeap ? ": Leap Year" : ": Not a Leap Year"));
    }
}
