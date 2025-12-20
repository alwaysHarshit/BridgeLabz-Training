package level1;

import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CLASS_SIZE = 10;
        int[] studentAges = new int[CLASS_SIZE];

        System.out.println("=== Student Age Input ===\n");

        for (int i = 0; i < CLASS_SIZE; i++) {
            System.out.printf("Enter age of student %d: ", i + 1);
            studentAges[i] = sc.nextInt();
        }

        System.out.println("\n=== Voting Eligibility Results ===\n");

        for (int i = 0; i < studentAges.length; i++) {
            int currentAge = studentAges[i];

            if (currentAge < 0) {
                System.out.printf("Student %d: Invalid age\n", i + 1);
            } else if (currentAge >= 18) {
                System.out.printf("Student %d: The student with age %d can vote.\n", i + 1, currentAge);
            } else {
                System.out.printf("Student %d: The student with age %d cannot vote.\n", i + 1, currentAge);
            }
        }
    }
}
