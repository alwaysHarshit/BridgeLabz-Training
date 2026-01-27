package com.java.Collections.MapInterfaces;
import java.util.Scanner;
import java.util.*;

public class WordFrequency {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> freq = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        return freq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        System.out.println(countWords(input));
    }
}