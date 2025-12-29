import java.util.Scanner;

public class splitTextComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = sc.nextLine();
        
        String[] customSplit = splitText(text);
        String[] builtInSplit = text.split(" ");
        
        boolean areEqual = compareArrays(customSplit, builtInSplit);
        
        System.out.println("Custom split result:");
        for (int i = 0; i < customSplit.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + customSplit[i]);
        }
        
        System.out.println("\nBuilt-in split result:");
        for (int i = 0; i < builtInSplit.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + builtInSplit[i]);
        }
        
        System.out.println("\nArrays are equal: " + areEqual);
    }
    
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
        
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                StringBuilder word = new StringBuilder();
                for (int j = startIndex; j < i; j++) {
                    word.append(text.charAt(j));
                }
                words[wordIndex] = word.toString();
                wordIndex++;
                startIndex = i + 1;
            }
        }
        
        StringBuilder lastWord = new StringBuilder();
        for (int j = startIndex; j < length; j++) {
            lastWord.append(text.charAt(j));
        }
        words[wordIndex] = lastWord.toString();
        
        return words;
    }
    
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
} 