package com.DSA.LinearBinarySearch;
public class FirstLastOccurence {
    public static int firstOccurrence(int[] arr, int target) {
        int res = -1, left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (arr[mid] == target) res = mid;
        }
        return res;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int res = -1, left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (arr[mid] == target) res = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};
        int target = 2;
        System.out.println("First: " + firstOccurrence(arr, target));
        System.out.println("Last: " + lastOccurrence(arr, target));
    }
}
