import java.util.LinkedHashSet;
import java.util.Scanner;

public class LexialTwist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first word:");
        String word1 = scanner.nextLine();

        System.out.println("Enter second word:");
        String word2 = scanner.nextLine();

        // Validation: Check if inputs contain more than one word
        if (word1.contains(" ")) {
            System.out.println(word1 + " is an invalid word");
            return;
        }
        if (word2.contains(" ")) {
            System.out.println(word2 + " is an invalid word");
            return;
        }

        // Check if second word is reversed version of first word
        if (isReversed(word1, word2)) {
            processReversedWords(word1);
        } else {
            processNonReversedWords(word1, word2);
        }

        scanner.close();
    }

    private static boolean isReversed(String word1, String word2) {
        String reversedWord1 = new StringBuilder(word1).reverse().toString();
        return reversedWord1.equalsIgnoreCase(word2);
    }

    private static void processReversedWords(String word) {
        // Step 1: Reverse the first word
        String reversed = new StringBuilder(word).reverse().toString();

        // Step 2: Convert to lowercase
        String lowercase = reversed.toLowerCase();

        // Step 3: Replace all vowels with '@'
        String transformed = lowercase.replaceAll("[aeiou]", "@");

        // Step 4: Print the transformed word
        System.out.println(transformed);
    }

    private static void processNonReversedWords(String word1, String word2) {
        // Step 1: Combine the words
        String combined = word1 + word2;

        // Step 2: Convert to uppercase
        String uppercase = combined.toUpperCase();

        // Step 3: Count vowels and consonants
        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : uppercase.toCharArray()) {
            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        // Step 4: Process based on counts
        if (vowelCount > consonantCount) {
            printFirstTwoUnique(uppercase, true);
        } else if (consonantCount > vowelCount) {
            printFirstTwoUnique(uppercase, false);
        } else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toUpperCase(c);
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static void printFirstTwoUnique(String word, boolean findVowels) {
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if (findVowels && isVowel(c)) {
                    uniqueChars.add(c);
                    if (uniqueChars.size() == 2) break;
                } else if (!findVowels && !isVowel(c)) {
                    uniqueChars.add(c);
                    if (uniqueChars.size() == 2) break;
                }
            }
        }

        for (char c : uniqueChars) {
            System.out.print(c);
        }
        System.out.println();
    }
}
