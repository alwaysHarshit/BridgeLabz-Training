import java.util.Scanner;

public class CalendarDisplay {
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static String getMonthName(int m) {
        return months[m-1];
    }

    public static int getDaysInMonth(int m, int y) {
        if (m == 2 && isLeapYear(y)) return 29;
        return days[m-1];
    }

    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // Zeller's Congruence for Gregorian calendar
    public static int getFirstDay(int m, int y) {
        if (m < 3) { m += 12; y--; }
        int K = y % 100;
        int J = y / 100;
        int h = (1 + (13*(m+1))/5 + K + K/4 + J/4 + 5*J) % 7;
        return (h + 6) % 7; // 0=Sunday
    }

    public static void displayCalendar(int m, int y) {
        System.out.printf("\n  %s %d\n", getMonthName(m), y);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int firstDay = getFirstDay(m, y);
        int numDays = getDaysInMonth(m, y);
        for (int i = 0; i < firstDay; i++) System.out.print("   ");
        for (int d = 1; d <= numDays; d++) {
            System.out.printf("%3d", d);
            if ((d + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        displayCalendar(m, y);
        sc.close();
    }
}
