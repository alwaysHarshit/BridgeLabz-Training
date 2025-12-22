package level2;
import java.util.Scanner;

public class trimWithoutTrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with spaces:");
        String text = sc.nextLine();
        
        String customTrim = trimString(text);
        String builtInTrim = text.trim();
        
        boolean areEqual = compareStrings(customTrim, builtInTrim);
        
        System.out.println("Original: '" + text + "'");
        System.out.println("Custom trim: '" + customTrim + "'");
        System.out.println("Built-in trim: '" + builtInTrim + "'");
        System.out.println("Results match: " + areEqual);
    }
    
    public static int[] findStartEndIndices(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end + 1};
    }
    
    public static String trimString(String text) {
        int[] indices = findStartEndIndices(text);
        int start = indices[0];
        int end = indices[1];
        
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        
        return result.toString();
    }
    
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
} 