package level2;
import java.util.Scanner;
import java.util.Random;

public class studentScorecard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        
        int[][] pcmScores = generateRandomScores(n);
        float[][] calculations = calculateResults(pcmScores);
        String[][] grades = assignGrades(calculations);
        
        displayScorecard(pcmScores, calculations, grades);
    }
    
    public static int[][] generateRandomScores(int n) {
        Random random = new Random();
        int[][] scores = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            scores[i][0] = random.nextInt(91) + 10;
            scores[i][1] = random.nextInt(91) + 10;
            scores[i][2] = random.nextInt(91) + 10;
        }
        
        return scores;
    }
    
    public static float[][] calculateResults(int[][] pcmScores) {
        float[][] results = new float[pcmScores.length][3];
        
        for (int i = 0; i < pcmScores.length; i++) {
            int total = pcmScores[i][0] + pcmScores[i][1] + pcmScores[i][2];
            float average = (float) total / 3;
            float percentage = (float) total / 300 * 100;
            
            results[i][0] = Math.round(total * 100.0f) / 100.0f;
            results[i][1] = Math.round(average * 100.0f) / 100.0f;
            results[i][2] = Math.round(percentage * 100.0f) / 100.0f;
        }
        
        return results;
    }
    
    public static String[][] assignGrades(float[][] calculations) {
        String[][] grades = new String[calculations.length][1];
        
        for (int i = 0; i < calculations.length; i++) {
            float percentage = calculations[i][2];
            
            if (percentage >= 90) {
                grades[i][0] = "A+";
            } else if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B+";
            } else if (percentage >= 60) {
                grades[i][0] = "B";
            } else if (percentage >= 50) {
                grades[i][0] = "C+";
            } else if (percentage >= 40) {
                grades[i][0] = "C";
            } else {
                grades[i][0] = "F";
            }
        }
        
        return grades;
    }
    
    public static void displayScorecard(int[][] pcmScores, float[][] calculations, String[][] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("----------------------------------------------------------------------------");
        
        for (int i = 0; i < pcmScores.length; i++) {
            System.out.println((i + 1) + "\t" + pcmScores[i][0] + "\t" + pcmScores[i][1] + "\t\t" + 
                             pcmScores[i][2] + "\t" + (int)calculations[i][0] + "\t" + 
                             calculations[i][1] + "\t" + calculations[i][2] + "%\t\t" + grades[i][0]);
        }
    }
} 