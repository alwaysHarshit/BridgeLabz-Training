package level2;


import java.util.Scanner;

public class divmod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int quo = n1 / n2;
        int rem = n1 % n2;

        System.out.println("The Quotient is " + quo + " and Reminder is " + rem + " of two number " + n1 + " and " + n2);

        sc.close();
    }
}
