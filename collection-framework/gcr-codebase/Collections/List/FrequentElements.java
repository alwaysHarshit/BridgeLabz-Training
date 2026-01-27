package com.java.Collections.List;
import java.util.*;
public class FrequentElements {
    public static Map<String, Integer> countFrequencies(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated strings: ");
        String[] inputArray = scanner.nextLine().split(" ");

        List<String> inputList = Arrays.asList(inputArray);
        Map<String, Integer> frequencies = countFrequencies(inputList);

        System.out.println("\nFrequencies: " + frequencies);

        scanner.close();
    }
}