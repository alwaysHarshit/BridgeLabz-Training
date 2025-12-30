public class PalindromeChecker {
    private String text;
    
    public PalindromeChecker(String text) {
        this.text = text;
    }
    
    public boolean isPalindrome() {
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: The text is a palindrome");
        } else {
            System.out.println("Result: The text is not a palindrome");
        }
    }
} 