package level3;

import java.util.Scanner;

public class frequencyNestedLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        String[] frequency = calculateFrequencyNested(text);
        
        System.out.println("Character\tFrequency");
        System.out.println("----------------------");
        for (int i = 0; i < frequency.length; i += 2) {
            if (frequency[i] != null && !frequency[i].equals("0")) {
                System.out.println(frequency[i] + "\t\t" + frequency[i + 1]);
            }
        }
    }
    
    public static String[] calculateFrequencyNested(String text) {
        char[] chars = text.toCharArray();
        String[] result = new String[chars.length * 2];
        int resultIndex = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            
            char currentChar = chars[i];
            int freq = 1;
            
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == currentChar) {
                    freq++;
                    chars[j] = '0';
                }
            }
            
            result[resultIndex] = String.valueOf(currentChar);
            result[resultIndex + 1] = String.valueOf(freq);
            resultIndex += 2;
        }
        
        return result;
    }
} 
