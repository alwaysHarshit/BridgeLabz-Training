package level2;
import java.util.Scanner;

public class findLengthWithoutLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.next();
        
        int customLength = findLength(text);
        int builtInLength = text.length();
        
        System.out.println("Custom length: " + customLength);
        System.out.println("Built-in length: " + builtInLength);
        System.out.println("Results match: " + (customLength == builtInLength));
    }
    
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
} 