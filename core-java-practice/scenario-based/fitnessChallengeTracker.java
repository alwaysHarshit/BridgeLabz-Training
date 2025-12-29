
import java.util.Arrays;
import java.util.Scanner;

public class fitnessChallengeTracker {
    public static void main(String[] args) {
        // array use kar rha hu , 7 size a , to store  a week count
        int []counts=new int[7];
        for (int day = 0; day<7 ; day++) {
            System.out.println("Enter the the number of push at day:" +(day+1));
            int num= new Scanner(System.in).nextInt();
            counts[day]=num;
        }
        // to show total push ups
        int total= calculateTotalPushups(counts);
        System.out.println("The total push are :"+ total);

        // to show avg push ups
        double avg= calculateAvg(counts,total);
        System.out.println("the avg is :"+ avg);


    }

    private static double calculateAvg(int[] counts, int total) {
        return total/ counts.length;
    }

    private static int calculateTotalPushups(int[] counts) {
        return Arrays.stream(counts).sum();
    }
}
