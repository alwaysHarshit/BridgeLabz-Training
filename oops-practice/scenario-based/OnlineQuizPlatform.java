package scenariobased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform {
    private String[] correctAnswers;
    private List<Integer> userScores;

    public OnlineQuizPlatform(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.userScores = new ArrayList<>();
    }

    public int evaluateQuiz(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException(
                String.format("Expected %d answers but received %d", correctAnswers.length, userAnswers.length)
            );
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i].trim())) {
                score++;
            }
        }

        userScores.add(score);
        return score;
    }

    public String calculateGrade(int score) {
        double percentage = (score * 100.0) / correctAnswers.length;

        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public void displayResult(String userName, int score) {
        String grade = calculateGrade(score);
        double percentage = (score * 100.0) / correctAnswers.length;

        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 QUIZ RESULTS FOR: " + userName);
        System.out.println("=".repeat(50));
        System.out.printf("Score: %d/%d%n", score, correctAnswers.length);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);
        System.out.println("=".repeat(50));
    }

    public void showAllScores() {
        if (userScores.isEmpty()) {
            System.out.println("No quiz submissions yet.");
            return;
        }

        System.out.println("\n📈 All User Scores:");
        int userNumber = 1;
        for (Integer score : userScores) {
            System.out.printf("User %d: %d/%d (%s)%n",
                userNumber++, score, correctAnswers.length, calculateGrade(score));
        }
    }

    public void displayCorrectAnswers() {
        System.out.println("\n✓ Correct Answers:");
        for (int i = 0; i < correctAnswers.length; i++) {
            System.out.printf("Q%d: %s%n", i + 1, correctAnswers[i]);
        }
    }

    public static void main(String[] args) {
        String[] correctAnswers = {"B", "A", "C", "D", "B", "A", "C", "B", "D", "A"};
        OnlineQuizPlatform platform = new OnlineQuizPlatform(correctAnswers);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Online Quiz Platform ===");
            System.out.println("1. Take Quiz");
            System.out.println("2. View All Scores");
            System.out.println("3. Show Answer Key");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();

                    System.out.println("\nAnswer the following 10 questions (A/B/C/D):");
                    String[] userAnswers = new String[correctAnswers.length];

                    for (int i = 0; i < correctAnswers.length; i++) {
                        System.out.printf("Question %d: ", i + 1);
                        userAnswers[i] = scanner.nextLine();
                    }

                    try {
                        int score = platform.evaluateQuiz(userAnswers);
                        platform.displayResult(userName, score);
                    } catch (InvalidQuizSubmissionException e) {
                        System.out.println("Submission Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    platform.showAllScores();
                    break;

                case 3:
                    platform.displayCorrectAnswers();
                    break;

                case 4:
                    System.out.println("Good luck with your studies!");
                    return;

                default:
                    System.out.println("That's not a valid option.");
            }
        }
    }
}
