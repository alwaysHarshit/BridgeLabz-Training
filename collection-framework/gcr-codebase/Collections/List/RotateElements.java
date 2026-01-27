package com.java.Collections.List;
import java.util.*;
public class RotateElements {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size; // handle rotations greater than size
        if (positions == 0) return;

        List<T> rotated = new ArrayList<>();

        rotated.addAll(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));

        for (int i = 0; i < size; i++) {
            list.set(i, rotated.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter space-separated list elements: ");
        String[] inputArray = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(inputArray));

        System.out.print("Rotate by how many positions? ");
        int positions = scanner.nextInt();

        rotateList(list, positions);
        System.out.println("Rotated List: " + list);

        scanner.close();
    }
}