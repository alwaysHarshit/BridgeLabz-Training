import java.util.Scanner;

public class checkHarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orginalNumber = sc.nextInt();
        int n = orginalNumber;
        int sum = 0;
        while (orginalNumber > 0) {
            int rem = orginalNumber % 10;
            sum += rem;
            orginalNumber /= 10;
        }
        System.out.println(n%sum==0?"Harshad Number":"Not a Harshad Number");
    }
}
