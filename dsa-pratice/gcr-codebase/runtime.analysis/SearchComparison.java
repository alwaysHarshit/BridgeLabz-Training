package runtime.analysis;

import java.util.Arrays;

/**
 * Problem Statement 1: Search a Target in a Large Dataset
 * Compare Linear Search (O(N)) vs Binary Search (O(log N))
 */
public class SearchComparison {

    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log N) - requires sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Performance comparison
    public static void comparePerformance(int[] sizes) {
        System.out.println("=== Search Algorithm Performance Comparison ===\n");
        System.out.printf("%-15s %-20s %-20s%n", "Dataset Size", "Linear Search", "Binary Search");
        System.out.println("-".repeat(55));

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i;
            }

            int target = size - 1; // Search for last element (worst case)

            // Linear Search timing
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Binary Search timing (data already sorted)
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20s %-20s%n",
                size,
                formatTime(linearTime),
                formatTime(binaryTime));
        }
    }

    private static String formatTime(long nanos) {
        if (nanos < 1000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.2f µs", nanos / 1000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.2f ms", nanos / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanos / 1_000_000_000.0);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};
        comparePerformance(sizes);

        System.out.println("\n📊 Analysis:");
        System.out.println("- Linear Search: O(N) - scales linearly with dataset size");
        System.out.println("- Binary Search: O(log N) - significantly faster for large datasets");
        System.out.println("- Binary Search requires sorted data");
    }
}
