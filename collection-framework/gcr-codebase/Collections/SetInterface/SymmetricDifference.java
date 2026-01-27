package com.java.Collections.SetInterface;
import java.util.*;

public class SymmetricDifference {
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2); // Union

        Set<T> common = new HashSet<>(set1);
        common.retainAll(set2); 

        result.removeAll(common); 
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for Set1 (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        Set<String> set1 = new HashSet<>(Arrays.asList(input1));

        System.out.print("Enter elements for Set2 (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        Set<String> set2 = new HashSet<>(Arrays.asList(input2));

        Set<String> symmetricDiff = getSymmetricDifference(set1, set2);
        System.out.println("\nSymmetric Difference: " + symmetricDiff);

        scanner.close();
    }
}