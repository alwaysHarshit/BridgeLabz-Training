import java.util.*;
public class Line_Comparison {
    public int calculateLength(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    public int compareLines(int length1, int length2) {
        if (length1 == length2) {
            return 0; // Lines are equal
        } else if (length1 > length2) {
            return 1; // First line is longer
        } else {
            return -1; // Second line is longer
        }
    }
    public int compare_lines_accordind_to_end_points(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        if (x1 == a1 && y1 == b1 && x2 == a2 && y2 == b2) {
            return 0; // Lines are equal
        } else if (x1 > a1 || y1 > b1 || x2 > a2 || y2 > b2) {
            return 1; // First line is longer
        } else {
            return -1; // Second line is longer
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();

        System.out.println("Welcome to Line Comparison Computation Program");
        System.out.println("Enter coordinates of first line (x1, y1, x2, y2):");
        int x1 = r.nextInt(10);
        int y1 = r.nextInt(10);
        int x2 = r.nextInt(10);
        int y2 = r.nextInt(10);
        System.out.println("Enter coordinates of second line (a1, b1, a2, b2):");
        int a1 = r.nextInt(10);
        int b1 = r.nextInt(10);
        int a2 = r.nextInt(10);
        int b2 = r.nextInt(10);
        System.out.println("First Line End Points: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")");
        System.out.println("Second Line End Points: (" + a1 + ", " + b1 + "), (" + a2 + ", " + b2 + ")");
        Line_Comparison lineComparison = new Line_Comparison();
        int length1 = lineComparison.calculateLength(x1, y1, x2, y2);
        int length2 = lineComparison.calculateLength(a1, b1, a2, b2);
        //Uc1
        System.out.println("Length of first line: " + length1);
        System.out.println("Length of second line: " + length2);
        //Uc2
        int comparisonResult = lineComparison.compareLines(length1, length2);
        if (comparisonResult == 0) {
            System.out.println("Both lines are equal in length.");
        } else if (comparisonResult == 1) {
            System.out.println("First line is longer than the second line.");
        } else {
            System.out.println("Second line is longer than the first line.");
        }
        //Uc3
        int endpointComparisonResult = lineComparison.compare_lines_accordind_to_end_points(x1, y1, x2, y2, a1, b1, a2, b2);
        if (endpointComparisonResult == 0) {
            System.out.println("Both lines are equal based on their end points.");
        } else if (endpointComparisonResult == 1) {
            System.out.println("First line is longer than the second line based on their end points.");
        } else {
            System.out.println("Second line is longer than the first line based on their end points.");
        }
    }
}