package level3;

import java.util.Scanner;

public class characterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        String[][] frequency = calculateFrequency(text);
        
        System.out.println("Character\tFrequency");
        System.out.println("----------------------");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][0] != null) {
                System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
            }
        }
    }
    
    public static String[][] calculateFrequency(String text) {
        int[] freq = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }
        
        String[][] result = new String[count][2];
        int index = 0;
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        
        return result;
    }
} 