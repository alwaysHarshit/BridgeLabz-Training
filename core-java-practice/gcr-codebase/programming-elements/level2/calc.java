package level2;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float n1 = sc.nextFloat();
        float n2 = sc.nextFloat();

        float a = n1 + n2;
        float s = n1 - n2;
        float m = n1 * n2;
        float d = n1 / n2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + n1 + " and " + n2 + " is " + a + ", " + s + ", " + m + ", and " + d);

        sc.close();
    }
}
