package com.java.Collections.Queue;
import java.util.*;

public class ReverseQueue {
    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty()) return;

        T front = queue.remove();

        reverse(queue);

        queue.add(front);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated queue elements: ");
        String[] input = scanner.nextLine().split(" ");

        Queue<String> queue = new LinkedList<>(Arrays.asList(input));

        System.out.println("\nOriginal Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);

        scanner.close();
    }
}