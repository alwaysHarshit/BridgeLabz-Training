package runtime.analysis;

/**
 * Problem Statement 5: Recursive vs Iterative Fibonacci Computation
 * Compare Recursive (O(2^n)) vs Iterative (O(N)) vs Memoization (O(N))
 */
public class FibonacciComparison {

    // Recursive Fibonacci - O(2^n) - extremely inefficient
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci - O(N) - efficient
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Fibonacci with Memoization - O(N) - efficient with recursion
    public static long fibonacciMemoization(int n) {
        long[] memo = new long[n + 1];
        return fibMemo(n, memo);
    }

    private static long fibMemo(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    // Dynamic Programming approach - O(N)
    public static long fibonacciDP(int n) {
        if (n <= 1) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Performance comparison
    public static void comparePerformance(int[] values) {
        System.out.println("=== Fibonacci Computation Performance Comparison ===\n");
        System.out.printf("%-15s %-20s %-20s %-20s %-20s %-15s%n",
            "Fibonacci(N)", "Recursive", "Iterative", "Memoization", "DP", "Result");
        System.out.println("-".repeat(110));

        for (int n : values) {
            // Recursive timing (skip for large values)
            String recursiveTime;
            if (n <= 40) {
                long startTime = System.nanoTime();
                long result = fibonacciRecursive(n);
                long elapsed = System.nanoTime() - startTime;
                recursiveTime = formatTime(elapsed);
            } else {
                recursiveTime = "Skipped (too slow)";
            }

            // Iterative timing
            long startTime = System.nanoTime();
            long iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;

            // Memoization timing
            startTime = System.nanoTime();
            long memoResult = fibonacciMemoization(n);
            long memoTime = System.nanoTime() - startTime;

            // Dynamic Programming timing
            startTime = System.nanoTime();
            long dpResult = fibonacciDP(n);
            long dpTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20s %-20s %-20s %-20s %-15d%n",
                n,
                recursiveTime,
                formatTime(iterativeTime),
                formatTime(memoTime),
                formatTime(dpTime),
                iterativeResult);
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

    // Demonstrate the exponential growth of recursive calls
    public static void demonstrateRecursiveGrowth() {
        System.out.println("\n=== Recursive Call Count Demonstration ===");
        System.out.printf("%-10s %-20s%n", "Fib(N)", "Recursive Calls");
        System.out.println("-".repeat(30));

        for (int n = 1; n <= 10; n++) {
            int calls = countRecursiveCalls(n);
            System.out.printf("%-10d %-20d%n", n, calls);
        }
    }

    private static int countRecursiveCalls(int n) {
        if (n <= 1) {
            return 1;
        }
        return 1 + countRecursiveCalls(n - 1) + countRecursiveCalls(n - 2);
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50, 70, 90};
        comparePerformance(values);

        demonstrateRecursiveGrowth();

        System.out.println("\n📊 Analysis:");
        System.out.println("- Recursive: O(2^n) - grows exponentially, impractical for n > 40");
        System.out.println("- Iterative: O(N) - linear time, constant space, most efficient");
        System.out.println("- Memoization: O(N) - avoids redundant calculations in recursion");
        System.out.println("- Dynamic Programming: O(N) - bottom-up approach, uses O(N) space");
        System.out.println("\n💡 Recommendation:");
        System.out.println("- Use iterative approach for best performance");
        System.out.println("- Use memoization if recursion is required");
        System.out.println("- Avoid plain recursion for Fibonacci");
    }
}
