package level1;

import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userDefinedSubstring = getSubstringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("User-defined substring: " + userDefinedSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Both substrings are equal: " + compareStrings(userDefinedSubstring, builtInSubstring, 0));
    }

    private static String getSubstringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    private static boolean compareStrings(String s1, String s2, int index) {
        if (s1.length() != s2.length()) return false;
        if (index == s1.length()) return true;
        if (s1.charAt(index) != s2.charAt(index)) return false;
        return compareStrings(s1, s2, index + 1);
    }
}
