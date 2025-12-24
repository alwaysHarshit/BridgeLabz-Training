import java.util.Arrays;

public class FactorsArrayOperations {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }

    public static int greatestFactor(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static int product(int[] arr) {
        int prod = 1;
        for (int n : arr) prod *= n;
        return prod;
    }

    public static long productOfCubes(int[] arr) {
        long prod = 1;
        for (int n : arr) prod *= Math.pow(n, 3);
        return prod;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] factors = getFactors(n);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + greatestFactor(factors));
        System.out.println("Sum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Product of cubes: " + productOfCubes(factors));
    }
}
