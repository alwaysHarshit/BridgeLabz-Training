package com.DSA.LinearBinarySearch;
import java.util.*;

public class SearchChallenge {
    public static int findMissingPositive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) if (num > 0) set.add(num);
        for (int i = 1; i <= arr.length; i++)
            if (!set.contains(i)) return i;
        return arr.length + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findMissingPositive(arr));
        int target = 4;
        System.out.println("Index of " + target + ": " + binarySearch(arr, target));
    }
}
