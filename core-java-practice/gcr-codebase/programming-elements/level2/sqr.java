package level2;

import java.util.Scanner;

public class sqr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float p = sc.nextFloat();

        float s = p / 4;

        System.out.println("The length of the side is " + s + " whose perimeter is " + p);

        sc.close();
    }
}
