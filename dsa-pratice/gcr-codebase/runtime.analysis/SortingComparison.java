package runtime.analysis;

import java.util.Arrays;
import java.util.Random;

/**
 * Problem Statement 2: Sorting Large Data Efficiently
 * Compare Bubble Sort (O(N²)) vs Merge Sort (O(N log N)) vs Quick Sort (O(N log N))
 */
public class SortingComparison {

    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N) average case
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate random array
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }

    // Performance comparison
    public static void comparePerformance(int[] sizes) {
        System.out.println("=== Sorting Algorithm Performance Comparison ===\n");
        System.out.printf("%-15s %-20s %-20s %-20s%n", "Dataset Size", "Bubble Sort", "Merge Sort", "Quick Sort");
        System.out.println("-".repeat(75));

        for (int size : sizes) {
            int[] original = generateRandomArray(size);

            // Bubble Sort timing (skip for large datasets)
            String bubbleTime;
            if (size <= 10_000) {
                int[] bubbleArr = Arrays.copyOf(original, original.length);
                long startTime = System.nanoTime();
                bubbleSort(bubbleArr);
                long elapsed = System.nanoTime() - startTime;
                bubbleTime = formatTime(elapsed);
            } else {
                bubbleTime = "Skipped (too slow)";
            }

            // Merge Sort timing
            int[] mergeArr = Arrays.copyOf(original, original.length);
            long startTime = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            long mergeTime = System.nanoTime() - startTime;

            // Quick Sort timing
            int[] quickArr = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            long quickTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20s %-20s %-20s%n",
                size,
                bubbleTime,
                formatTime(mergeTime),
                formatTime(quickTime));
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
        int[] sizes = {1_000, 10_000, 100_000};
        comparePerformance(sizes);

        System.out.println("\n📊 Analysis:");
        System.out.println("- Bubble Sort: O(N²) - impractical for large datasets");
        System.out.println("- Merge Sort: O(N log N) - stable, consistent performance");
        System.out.println("- Quick Sort: O(N log N) avg - fastest in practice, but O(N²) worst case");
    }
}
