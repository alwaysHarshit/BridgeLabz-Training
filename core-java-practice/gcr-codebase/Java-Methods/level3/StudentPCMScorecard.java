import java.util.Random;
import java.util.Scanner;

public class StudentPCMScorecard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = new int[n][3];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = 35 + rand.nextInt(65); // 2-digit scores (35-99)
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t% ");
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = Math.round((total / 300.0) * 10000) / 100.0;
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\n", i+1, scores[i][0], scores[i][1], scores[i][2], total, avg, perc);
        }
        sc.close();
    }
}
