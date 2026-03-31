package com.DSA.SortingAlgorithms;
import java.util.Scanner;
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) arr[j + 1] = arr[j--];
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] ids = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) ids[i] = sc.nextInt();
        insertionSort(ids);
        System.out.println("Sorted Employee IDs:");
        for (int id : ids) System.out.print(id + " ");
    }
}
