import java.util.Scanner;
import java.util.Random;

public class votingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        
        int[] ages = generateRandomAges(n);
        String[][] eligibility = checkEligibility(ages);
        
        displayResults(eligibility);
    }
    
    public static int[] generateRandomAges(int n) {
        Random random = new Random();
        int[] ages = new int[n];
        
        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }
        
        return ages;
    }
    
    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        
        return result;
    }
    
    public static void displayResults(String[][] data) {
        System.out.println("Student\tAge\tCan Vote");
        System.out.println("------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t" + data[i][1]);
        }
    }
} 