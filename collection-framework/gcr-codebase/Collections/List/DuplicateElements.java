package com.java.Collections.List;
import java.util.*;

public class DuplicateElements {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        for (T item : list) {
            seen.add(item); // LinkedHashSet maintains insertion order
        }
        return new ArrayList<>(seen);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated list elements: ");
        String[] inputArray = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(inputArray));

        List<String> uniqueList = removeDuplicates(list);
        System.out.println("List after removing duplicates: " + uniqueList);

        scanner.close();
    }
}
