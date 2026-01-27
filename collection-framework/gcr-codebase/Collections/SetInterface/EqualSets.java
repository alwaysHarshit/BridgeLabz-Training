package com.java.Collections.SetInterface;
import java.util.*;

public class EqualSets {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2); // relies on Set's equals() method
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for Set1 (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        Set<String> set1 = new HashSet<>(Arrays.asList(input1));

        System.out.print("Enter elements for Set2 (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        Set<String> set2 = new HashSet<>(Arrays.asList(input2));

        boolean result = areSetsEqual(set1, set2);
        System.out.println("\nAre the two sets equal? " + result);

        scanner.close();
    }
}