import java.util.Random;
import java.util.Scanner;

public class EmployeeWageComputation {
    final  static  int fixedHours=100;
    final  static  int fixedDays=20;
    final  static  double fixedWagePerHour=20;
    final  static  int fullHours=8;

    public static void main(String[] args) {
        display();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Employee name");
        String employeeName=scanner.nextLine();

        int totalWorkingDay=0;
        int workingHours=0;
        double totalWage=0.0d;

        while(totalWorkingDay<fixedDays && workingHours<fixedHours){
            if(attendanceCheck(employeeName)){
                totalWorkingDay+=1;
                workingHours+=fullHours;
                System.out.println("Choose what you want to do:");
                System.out.println("1.Calculate the daily wage");
                System.out.println("2. add the part time ");

                int choose=scanner.nextInt();
                switch (choose){
                    case 1:
                        double dailyWage=fullHours*fixedWagePerHour;
                        System.out.println("Daily wage: $" + dailyWage);
                        totalWage+=dailyWage;
                        break;

                    case 2:
                        System.out.print("Enter part-time hours: ");
                        int partTimeHours = scanner.nextInt();
                        workingHours += partTimeHours;
                        double partTimeWage = fixedWagePerHour * partTimeHours;
                        System.out.println("Part-time wage added: $" + partTimeWage);
                        totalWage += partTimeWage;
                        break;
                }
            }
            else {
                System.out.println("Employee is not present today");
            }

        }




    }

    private static void  display(){
        System.out.println("Welcome to Employee Wage Computation Program ");
    }

    private static boolean attendanceCheck(String name) {
        Random rand =new Random();
        int num=rand.nextInt(3);
        return num == 1;
    }
}
