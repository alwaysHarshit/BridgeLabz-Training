package level2;

import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String[] friendNames = {"Amar", "Akbar", "Anthony"};
        final int FRIEND_COUNT = 3;

        int[] ages = new int[FRIEND_COUNT];
        double[] heights = new double[FRIEND_COUNT];

        System.out.println("=== Friend Age and Height Input ===\n");

        for (int i = 0; i < FRIEND_COUNT; i++) {
            System.out.printf("%s's details:\n", friendNames[i]);
            System.out.print("  Age: ");
            ages[i] = sc.nextInt();
            System.out.print("  Height (in cm): ");
            heights[i] = sc.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < FRIEND_COUNT; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("\n=== Results ===");
        System.out.printf("Youngest friend: %s (Age: %d)\n", 
                friendNames[youngestIndex], ages[youngestIndex]);
        System.out.printf("Tallest friend: %s (Height: %.2f cm)\n", 
                friendNames[tallestIndex], heights[tallestIndex]);
    }
}
