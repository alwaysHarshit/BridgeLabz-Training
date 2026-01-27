package com.java.Collections.List;

import java.util.*;

public class ReverseList {
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter elements for ArrayList (space-separated integers): ");
        String[] arrayInput = sc.nextLine().split(" ");
        List<Integer> arrayList = new ArrayList<>();

        for (String s : arrayInput) {
            try {
                arrayList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input '" + s + "'—skipping.");
            }
        }

        System.out.println("\nOriginal ArrayList: " + arrayList);

        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        sc.close(); 
    }
}