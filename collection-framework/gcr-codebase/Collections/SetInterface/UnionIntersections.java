package com.java.Collections.SetInterface;
import java.util.*;
public class UnionIntersections {
    public static <T> void computeUnionAndIntersection(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for Set1 (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        Set<String> set1 = new HashSet<>(Arrays.asList(input1));

        System.out.print("Enter elements for Set2 (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        Set<String> set2 = new HashSet<>(Arrays.asList(input2));

        computeUnionAndIntersection(set1, set2);

        scanner.close();
    }
}