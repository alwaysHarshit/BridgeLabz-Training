import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the month");
        int month = sc.nextInt();

        System.out.println("Enter the day of the week:");
        int day = sc.nextInt();

        System.out.println("Enter the year:");
        int year = sc.nextInt();

        int y =year-(14-month)/12;
        int m =month+12*(14-month)/12-2;
        int d =day+y+(y/4)-(y/100)+(y/400)+(31*m)/12;
        System.out.println("The day of the week is "+d);
    }
}
