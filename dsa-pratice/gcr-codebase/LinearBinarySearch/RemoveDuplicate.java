package com.DSA.LinearBinarySearch;
import java.util.*;

public class RemoveDuplicate {
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Without Duplicates: " + removeDuplicates(input));
    }
}
