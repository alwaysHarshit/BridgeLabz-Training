import java.util.Scanner;

public class palindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean reverseResult = isPalindromeReverse(text);
        
        System.out.println("String: " + text);
        System.out.println("Iterative approach: " + iterativeResult);
        System.out.println("Recursive approach: " + recursiveResult);
        System.out.println("Reverse comparison: " + reverseResult);
        
        if (iterativeResult && recursiveResult && reverseResult) {
            System.out.println("All methods agree: The string is a palindrome!");
        } else {
            System.out.println("All methods agree: The string is NOT a palindrome!");
        }
    }
    
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    public static boolean isPalindromeReverse(String text) {
        String reversed = reverseString(text);
        char[] original = text.toCharArray();
        char[] reversedArray = reversed.toCharArray();
        
        if (original.length != reversedArray.length) {
            return false;
        }
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static String reverseString(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }
} 