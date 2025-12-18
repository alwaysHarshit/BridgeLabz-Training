package level2;

import java.util.Scanner;

public class price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float up = sc.nextFloat();
        int q = sc.nextInt();

        float tp = up * q;

        System.out.println("The total purchase price is INR " + tp + " if the quantity " + q + " and unit price is INR " + up);

        sc.close();
    }
}
