import java.util.Scanner;

public class checkPrime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        for (int i = 2; i < number; i++) {
            if(number%i==0){
                System.out.println(number+" is not prime");
                break;
            }
        }
    }
}
