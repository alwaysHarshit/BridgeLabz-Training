package level3;

import java.util.Scanner;

public class frequencyUniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        String[][] frequency = calculateFrequencyUnique(text);
        
        System.out.println("Character\tFrequency");
        System.out.println("----------------------");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][0] != null) {
                System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
            }
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
    
    public static String[][] calculateFrequencyUnique(String text) {
        int length = findLength(text);
        char[] uniqueChars = new char[length];
        int uniqueCount = 0;
        
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueChars[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                uniqueChars[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        String[][] result = new String[uniqueCount][2];
        
        for (int i = 0; i < uniqueCount; i++) {
            char currentChar = uniqueChars[i];
            int freq = 0;
            
            for (int j = 0; j < length; j++) {
                if (text.charAt(j) == currentChar) {
                    freq++;
                }
            }
            
            result[i][0] = String.valueOf(currentChar);
            result[i][1] = String.valueOf(freq);
        }
        
        return result;
    }
} 