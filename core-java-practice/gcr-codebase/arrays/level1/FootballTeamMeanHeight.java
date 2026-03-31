package level1;

import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int TEAM_SIZE = 11;

        double[] heights = new double[TEAM_SIZE];

        System.out.println("=== Enter Heights of Football Players (in cm) ===\n");

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.printf("Player %d height: ", i + 1);
            heights[i] = sc.nextDouble();
        }

        double sumOfHeights = 0;

        for (int i = 0; i < heights.length; i++) {
            sumOfHeights += heights[i];
        }

        double meanHeight = sumOfHeights / TEAM_SIZE;

        System.out.printf("\n=== Results ===\n");
        System.out.printf("Total height: %.2f cm\n", sumOfHeights);
        System.out.printf("Mean height of the football team: %.2f cm\n", meanHeight);
    }
}
