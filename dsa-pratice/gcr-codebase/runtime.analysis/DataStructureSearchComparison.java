package runtime.analysis;

import java.util.*;

/**
 * Problem Statement 6: Comparing Different Data Structures for Searching
 * Compare Array (O(N)) vs HashSet (O(1)) vs TreeSet (O(log N))
 */
public class DataStructureSearchComparison {

    // Search in Array - O(N)
    public static boolean searchInArray(Integer[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // Search in ArrayList - O(N)
    public static boolean searchInArrayList(ArrayList<Integer> list, int target) {
        return list.contains(target);
    }

    // Search in HashSet - O(1) average case
    public static boolean searchInHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Search in TreeSet - O(log N)
    public static boolean searchInTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Search in HashMap - O(1) average case
    public static boolean searchInHashMap(HashMap<Integer, Integer> map, int target) {
        return map.containsKey(target);
    }

    // Generate test data
    private static Integer[] generateData(int size) {
        Integer[] data = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size * 10);
        }
        return data;
    }

    // Performance comparison
    public static void comparePerformance(int[] sizes) {
        System.out.println("=== Data Structure Search Performance Comparison ===\n");
        System.out.printf("%-15s %-15s %-18s %-15s %-15s %-15s%n",
            "Dataset Size", "Array", "ArrayList", "HashSet", "TreeSet", "HashMap");
        System.out.println("-".repeat(93));

        for (int size : sizes) {
            Integer[] data = generateData(size);

            // Create different data structures
            ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(data));
            HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(data));
            TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(data));
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (Integer value : data) {
                hashMap.put(value, value);
            }

            // Search for random elements (multiple searches for better accuracy)
            int searchCount = 1000;
            Random random = new Random();

            // Array search timing
            long startTime = System.nanoTime();
            for (int i = 0; i < searchCount; i++) {
                int target = random.nextInt(size * 10);
                searchInArray(data, target);
            }
            long arrayTime = (System.nanoTime() - startTime) / searchCount;

            // ArrayList search timing
            startTime = System.nanoTime();
            for (int i = 0; i < searchCount; i++) {
                int target = random.nextInt(size * 10);
                searchInArrayList(arrayList, target);
            }
            long arrayListTime = (System.nanoTime() - startTime) / searchCount;

            // HashSet search timing
            startTime = System.nanoTime();
            for (int i = 0; i < searchCount; i++) {
                int target = random.nextInt(size * 10);
                searchInHashSet(hashSet, target);
            }
            long hashSetTime = (System.nanoTime() - startTime) / searchCount;

            // TreeSet search timing
            startTime = System.nanoTime();
            for (int i = 0; i < searchCount; i++) {
                int target = random.nextInt(size * 10);
                searchInTreeSet(treeSet, target);
            }
            long treeSetTime = (System.nanoTime() - startTime) / searchCount;

            // HashMap search timing
            startTime = System.nanoTime();
            for (int i = 0; i < searchCount; i++) {
                int target = random.nextInt(size * 10);
                searchInHashMap(hashMap, target);
            }
            long hashMapTime = (System.nanoTime() - startTime) / searchCount;

            System.out.printf("%-15d %-15s %-18s %-15s %-15s %-15s%n",
                size,
                formatTime(arrayTime),
                formatTime(arrayListTime),
                formatTime(hashSetTime),
                formatTime(treeSetTime),
                formatTime(hashMapTime));
        }
    }

    // Memory comparison
    public static void compareMemory(int size) {
        System.out.println("\n=== Memory Usage Comparison (for " + size + " elements) ===");

        Integer[] data = generateData(size);
        Runtime runtime = Runtime.getRuntime();

        // Array memory
        runtime.gc();
        long beforeArray = runtime.totalMemory() - runtime.freeMemory();
        Integer[] arr = Arrays.copyOf(data, data.length);
        long afterArray = runtime.totalMemory() - runtime.freeMemory();

        // ArrayList memory
        runtime.gc();
        long beforeArrayList = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(data));
        long afterArrayList = runtime.totalMemory() - runtime.freeMemory();

        // HashSet memory
        runtime.gc();
        long beforeHashSet = runtime.totalMemory() - runtime.freeMemory();
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(data));
        long afterHashSet = runtime.totalMemory() - runtime.freeMemory();

        // TreeSet memory
        runtime.gc();
        long beforeTreeSet = runtime.totalMemory() - runtime.freeMemory();
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(data));
        long afterTreeSet = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("%-20s %-15s%n", "Data Structure", "Memory Used");
        System.out.println("-".repeat(35));
        System.out.printf("%-20s %-15s%n", "Array", formatMemory(afterArray - beforeArray));
        System.out.printf("%-20s %-15s%n", "ArrayList", formatMemory(afterArrayList - beforeArrayList));
        System.out.printf("%-20s %-15s%n", "HashSet", formatMemory(afterHashSet - beforeHashSet));
        System.out.printf("%-20s %-15s%n", "TreeSet", formatMemory(afterTreeSet - beforeTreeSet));
    }

    private static String formatTime(long nanos) {
        if (nanos < 1000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.2f µs", nanos / 1000.0);
        } else {
            return String.format("%.2f ms", nanos / 1_000_000.0);
        }
    }

    private static String formatMemory(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else {
            return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};
        comparePerformance(sizes);

        compareMemory(100_000);

        System.out.println("\n📊 Analysis:");
        System.out.println("- Array/ArrayList: O(N) - linear search, slowest for large datasets");
        System.out.println("- HashSet/HashMap: O(1) avg - fastest for lookups, uses hashing");
        System.out.println("- TreeSet: O(log N) - maintains sorted order, slower than HashSet");
        System.out.println("\n💡 Space-Time Tradeoffs:");
        System.out.println("- HashSet: Fast but uses more memory");
        System.out.println("- TreeSet: Moderate speed, maintains order, moderate memory");
        System.out.println("- Array: Slow search, least memory");
        System.out.println("\n💡 Recommendation:");
        System.out.println("- Use HashSet for frequent lookups (no ordering needed)");
        System.out.println("- Use TreeSet when you need sorted data with reasonable search speed");
        System.out.println("- Use Array/ArrayList when memory is critical and searches are rare");
    }
}
