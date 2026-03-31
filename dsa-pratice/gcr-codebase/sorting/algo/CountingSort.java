package sorting.algo;

import java.util.Scanner;
public class CountingSort {
    public static void countingSort(int[] arr, int maxAge) {
        int[] count = new int[maxAge + 1];
        for (int age : arr) count[age]++;
        int index = 0;
        for (int i = 0; i <= maxAge; i++)
            while (count[i]-- > 0) arr[index++] = i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter student ages (10–18):");
        for (int i = 0; i < n; i++) ages[i] = sc.nextInt();
        countingSort(ages, 18);
        System.out.println("Sorted Ages:");
        for (int age : ages) System.out.print(age + " ");
    }
}

