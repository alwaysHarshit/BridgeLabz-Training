package runtime.analysis;

/**
 * Problem Statement 3: String Concatenation Performance
 * Compare String (O(N²)) vs StringBuilder (O(N)) vs StringBuffer (O(N))
 */
public class StringConcatenationComparison {

    // Using String - O(N²) due to immutability
    public static String concatenateWithString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "a";
        }
        return result;
    }

    // Using StringBuilder - O(N), mutable, thread-unsafe
    public static String concatenateWithStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    // Using StringBuffer - O(N), mutable, thread-safe
    public static String concatenateWithStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    // Performance comparison
    public static void comparePerformance(int[] counts) {
        System.out.println("=== String Concatenation Performance Comparison ===\n");
        System.out.printf("%-15s %-20s %-20s %-20s%n", "Operations", "String", "StringBuilder", "StringBuffer");
        System.out.println("-".repeat(75));

        for (int count : counts) {
            // String concatenation timing (skip for very large counts)
            String stringTime;
            if (count <= 10_000) {
                long startTime = System.nanoTime();
                concatenateWithString(count);
                long elapsed = System.nanoTime() - startTime;
                stringTime = formatTime(elapsed);
            } else {
                stringTime = "Skipped (too slow)";
            }

            // StringBuilder timing
            long startTime = System.nanoTime();
            concatenateWithStringBuilder(count);
            long stringBuilderTime = System.nanoTime() - startTime;

            // StringBuffer timing
            startTime = System.nanoTime();
            concatenateWithStringBuffer(count);
            long stringBufferTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20s %-20s %-20s%n",
                count,
                stringTime,
                formatTime(stringBuilderTime),
                formatTime(stringBufferTime));
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
        int[] counts = {1_000, 10_000, 100_000, 1_000_000};
        comparePerformance(counts);

        System.out.println("\n📊 Analysis:");
        System.out.println("- String: O(N²) - creates new object on each concatenation (immutable)");
        System.out.println("- StringBuilder: O(N) - fastest, mutable, not thread-safe");
        System.out.println("- StringBuffer: O(N) - thread-safe, slightly slower than StringBuilder");
        System.out.println("\n💡 Recommendation:");
        System.out.println("- Use StringBuilder for single-threaded operations");
        System.out.println("- Use StringBuffer for multi-threaded operations");
    }
}
