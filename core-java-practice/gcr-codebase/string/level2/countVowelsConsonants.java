package level2;

import java.util.Scanner;

public class countVowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        int[] counts = countVowelsAndConsonants(text);
        
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        System.out.println("Other characters: " + counts[2]);
    }
    
    public static String classifyCharacter(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        int others = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String type = classifyCharacter(c);
            
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            } else {
                others++;
            }
        }
        
        return new int[]{vowels, consonants, others};
    }
} 