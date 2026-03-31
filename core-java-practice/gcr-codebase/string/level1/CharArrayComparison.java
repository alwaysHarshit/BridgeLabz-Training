package level1;

import java.util.Scanner;

public class CharArrayComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();

        char[] userDefinedArray = getCharArrayUsingCharAt(text);
        char[] builtInArray = text.toCharArray();

        System.out.println("User-defined char array: " + new String(userDefinedArray));
        System.out.println("Built-in char array: " + new String(builtInArray));
        System.out.println("Both arrays are equal: " + compareCharArrays(userDefinedArray, builtInArray, 0));
    }

    private static char[] getCharArrayUsingCharAt(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    private static boolean compareCharArrays(char[] arr1, char[] arr2, int index) {
        if (arr1.length != arr2.length) return false;
        if (index == arr1.length) return true;
        if (arr1[index] != arr2[index]) return false;
        return compareCharArrays(arr1, arr2, index + 1);
    }
}
