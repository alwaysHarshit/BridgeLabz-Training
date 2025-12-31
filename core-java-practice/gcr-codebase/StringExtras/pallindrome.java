import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "anna";
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                System.out.print("No palindrome");
                return;
            }
        }
        System.out.print("Palindrome");
    }
}