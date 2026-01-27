package com.java.Collections.SetInterface;
import java.util.*;

public class SetToList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); 
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated integers for the set: ");
        String[] input = scanner.nextLine().split(" ");
        Set<Integer> intSet = new HashSet<>();

        for (String s : input) {
            try {
                intSet.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + s);
            }
        }

        List<Integer> sortedList = convertAndSort(intSet);
        System.out.println("Sorted List: " + sortedList);

        scanner.close();
    }
}