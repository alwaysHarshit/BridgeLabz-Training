package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class KeyGeneration {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(bf.readLine().trim());

        while (n-- >0){
            String s = bf.readLine().trim();
            System.out.println(process(s));
        }
    }

    private static String process(String s) {
        if (s.length() < 6) return "Invalid Input (length < 6)";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))       return "Invalid Input (contains digits)";
            else if (Character.isSpaceChar(c)) return "Invalid Input (contains space)";
            else if ("!@#$%^&*.".indexOf(c) != -1) return "Invalid Input (contains special character)";
        }

        // Step 1: lowercase + reverse
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        sb.reverse();

        // Step 2: remove even ASCII characters (don't skip after delete)
        for (int i = 0; i < sb.length(); ) {
            int ascii = (int) sb.charAt(i);
            if (ascii % 2 == 0) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }

        // Step 3: uppercase at even indices
        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 0) {
                sb.replace(i, i + 1, String.valueOf(Character.toUpperCase(sb.charAt(i))));
            }
        }

        return "The generated key is - " + sb.toString();
    }
}
