package level2;

import java.util.Scanner;

public class triArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float b = sc.nextFloat();
        float h = sc.nextFloat();

        float acm = 0.5f * b * h;
        float ain = acm / (2.54f * 2.54f);

        System.out.println("The Area of the triangle in sq in is " + ain + " and sq cm is " + acm);

        sc.close();
    }
}
