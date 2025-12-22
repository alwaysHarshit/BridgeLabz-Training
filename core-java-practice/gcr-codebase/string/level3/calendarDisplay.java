package level3;

import java.util.Scanner;

public class calendarDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month (1-12):");
        int month = sc.nextInt();
        System.out.println("Enter year:");
        int year = sc.nextInt();
        
        displayCalendar(month, year);
    }
    
    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month];
    }
    
    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static int getStartDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        return d0;
    }
    
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int startDay = getStartDay(month, year);
        
        System.out.println("\n\t\t" + monthName + " " + year);
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < startDay; i++) {
            System.out.print("\t");
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d\t", day);
            
            if ((startDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        
        if ((startDay + daysInMonth) % 7 != 0) {
            System.out.println();
        }
    }
} 