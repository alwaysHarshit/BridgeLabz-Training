import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amarAge = sc.nextInt();
        double amarHeight = sc.nextDouble();

        int akbarAge = sc.nextInt();
        double akbarHeight = sc.nextDouble();

        int anthonyAge = sc.nextInt();
        double anthonyHeight = sc.nextDouble();

        int youngestAge = amarAge;
        String youngest = "Amar";

        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngest = "Akbar";
        }

        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngest = "Anthony";
        }

        double tallestHeight = amarHeight;
        String tallest = "Amar";

        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallest = "Akbar";
        }

        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallest = "Anthony";
        }

        System.out.println(youngest);
        System.out.println(tallest);
    }
}
