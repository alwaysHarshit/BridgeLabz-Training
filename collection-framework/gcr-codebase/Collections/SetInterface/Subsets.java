package com.java.Collections.SetInterface;
import java.util.*;

public class Subsets {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for Set1 (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        Set<String> set1 = new HashSet<>(Arrays.asList(input1));

        System.out.print("Enter elements for Set2 (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        Set<String> set2 = new HashSet<>(Arrays.asList(input2));

        boolean result = isSubset(set1, set2);
        System.out.println("\nIs Set1 a subset of Set2? " + result);

        scanner.close();
    }
}
