package level2;
import java.util.Scanner;

public class wordLength2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = sc.nextLine();
        
        String[][] result = splitAndGetLengths(text);
        
        System.out.println("Word\t\tLength");
        System.out.println("----------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
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
    
    public static int findWordLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static String[][] splitAndGetLengths(String text) {
        int length = findLength(text);
        int wordCount = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
        
        String[][] result = new String[wordCount][2];
        int wordIndex = 0;
        int startIndex = 0;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                StringBuilder word = new StringBuilder();
                for (int j = startIndex; j < i; j++) {
                    word.append(text.charAt(j));
                }
                String wordStr = word.toString();
                result[wordIndex][0] = wordStr;
                result[wordIndex][1] = String.valueOf(findWordLength(wordStr));
                wordIndex++;
                startIndex = i + 1;
            }
        }
        
        StringBuilder lastWord = new StringBuilder();
        for (int j = startIndex; j < length; j++) {
            lastWord.append(text.charAt(j));
        }
        String lastWordStr = lastWord.toString();
        result[wordIndex][0] = lastWordStr;
        result[wordIndex][1] = String.valueOf(findWordLength(lastWordStr));
        
        return result;
    }
} 