package com.java.Collections.List;
import java.util.*;

public class NthElement {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Invalid input.");
        }

        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        int count = 0;
        while (count < n && first.hasNext()) {
            first.next();
            count++;
        }

        if (count < n) {
            throw new IllegalArgumentException("List has fewer than " + n + " elements.");
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // This gives the Nth from end
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated elements: ");
        String[] input = scanner.nextLine().split(" ");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(input));

        System.out.print("Enter N (position from end): ");
        int n = scanner.nextInt();

        try {
            String result = findNthFromEnd(list, n);
            System.out.println("Nth element from end: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}