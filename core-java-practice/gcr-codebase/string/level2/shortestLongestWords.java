import java.util.Scanner;

public class shortestLongestWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = sc.nextLine();
        
        String[][] wordsAndLengths = splitAndGetLengths(text);
        String[] result = findShortestAndLongest(wordsAndLengths);
        
        System.out.println("All words and their lengths:");
        System.out.println("Word\t\tLength");
        System.out.println("----------------------");
        for (int i = 0; i < wordsAndLengths.length; i++) {
            System.out.println(wordsAndLengths[i][0] + "\t\t" + wordsAndLengths[i][1]);
        }
        
        System.out.println("\nShortest word: " + result[0] + " (Length: " + result[1] + ")");
        System.out.println("Longest word: " + result[2] + " (Length: " + result[3] + ")");
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
    
    public static String[] findShortestAndLongest(String[][] wordsAndLengths) {
        String shortestWord = wordsAndLengths[0][0];
        String shortestLength = wordsAndLengths[0][1];
        String longestWord = wordsAndLengths[0][0];
        String longestLength = wordsAndLengths[0][1];
        
        for (int i = 1; i < wordsAndLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsAndLengths[i][1]);
            int shortestLen = Integer.parseInt(shortestLength);
            int longestLen = Integer.parseInt(longestLength);
            
            if (currentLength < shortestLen) {
                shortestWord = wordsAndLengths[i][0];
                shortestLength = wordsAndLengths[i][1];
            }
            if (currentLength > longestLen) {
                longestWord = wordsAndLengths[i][0];
                longestLength = wordsAndLengths[i][1];
            }
        }
        
        return new String[]{shortestWord, shortestLength, longestWord, longestLength};
    }
} 