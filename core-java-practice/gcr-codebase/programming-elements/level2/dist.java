package level2;

import java.util.Scanner;

public class dist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float f = sc.nextFloat();

        float y = f / 3;
        float mi = y / 1760;

        System.out.println("The distance in yards is " + y + " while the distance in miles is " + mi);

        sc.close();
    }
}
