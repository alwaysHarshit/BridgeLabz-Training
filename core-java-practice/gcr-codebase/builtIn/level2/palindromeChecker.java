import java.util.Scanner;

public class palindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        boolean isPalindrome = checkPalindrome(input);
        displayResult(input, isPalindrome);
    }
    
    public static boolean checkPalindrome(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void displayResult(String input, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("'" + input + "' is a palindrome.");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }
    }
} 