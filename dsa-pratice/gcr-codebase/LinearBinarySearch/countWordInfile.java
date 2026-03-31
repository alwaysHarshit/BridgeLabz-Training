package com.DSA.LinearBinarySearch;
import java.io.*;

public class countWordInfile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String wordToFind = "java";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words)
                if (word.equalsIgnoreCase(wordToFind))
                    count++;
        }
        br.close();
        System.out.println("Occurrences of \"" + wordToFind + "\": " + count);
    }
}
