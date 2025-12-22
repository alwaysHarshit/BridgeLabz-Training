package level1;

import java.util.Scanner;

public class LowerCaseConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String userDefinedLowerCase = convertToLowerCaseUsingCharAt(text);
        String builtInLowerCase = text.toLowerCase();

        System.out.println("User-defined lowercase: " + userDefinedLowerCase);
        System.out.println("Built-in lowercase: " + builtInLowerCase);
        System.out.println("Both strings are equal: " + compareStrings(userDefinedLowerCase, builtInLowerCase, 0));
    }

    private static String convertToLowerCaseUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
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
