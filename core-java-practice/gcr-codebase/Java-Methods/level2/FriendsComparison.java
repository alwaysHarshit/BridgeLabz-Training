import java.util.Scanner;

public class FriendsComparison {
    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) {
                youngest = age;
            }
        }
        return youngest;
    }

    public static double findTallest(double[] heights) {
        double tallest = heights[0];
        for (double height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            
            System.out.print("Enter height (in cm) for " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }
        
        int youngest = findYoungest(ages);
        double tallest = findTallest(heights);
        
        System.out.println("\nResults:");
        System.out.println("Youngest friend(s):");
        for (int i = 0; i < 3; i++) {
            if (ages[i] == youngest) {
                System.out.println(names[i] + " (Age: " + youngest + ")");
            }
        }
        
        System.out.println("\nTallest friend(s):");
        for (int i = 0; i < 3; i++) {
            if (heights[i] == tallest) {
                System.out.println(names[i] + " (Height: " + tallest + " cm)");
            }
        }
        
        scanner.close();
    }
} 