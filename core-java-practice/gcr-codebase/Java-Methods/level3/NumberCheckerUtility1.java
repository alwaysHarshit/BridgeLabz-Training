import java.util.Arrays;

public class NumberCheckerUtility1 {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public static int[] digitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    public static boolean isDuckNumber(int n) {
        String s = String.valueOf(Math.abs(n));
        return s.substring(1).contains("0");
    }

    public static boolean isArmstrong(int n) {
        int[] arr = digitsArray(n);
        int sum = 0, len = arr.length;
        for (int d : arr) sum += Math.pow(d, len);
        return sum == n;
    }

    public static int[] largestAndSecondLargest(int n) {
        int[] arr = digitsArray(n);
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int d : arr) {
            if (d > max1) { max2 = max1; max1 = d; }
            else if (d > max2 && d != max1) max2 = d;
        }
        return new int[]{max1, max2};
    }

    public static int[] smallestAndSecondSmallest(int n) {
        int[] arr = digitsArray(n);
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : arr) {
            if (d < min1) { min2 = min1; min1 = d; }
            else if (d < min2 && d != min1) min2 = d;
        }
        return new int[]{min1, min2};
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println("Number: " + n);
        System.out.println("Digit count: " + countDigits(n));
        System.out.println("Digits: " + Arrays.toString(digitsArray(n)));
        System.out.println("Duck number: " + isDuckNumber(n));
        System.out.println("Armstrong number: " + isArmstrong(n));
        System.out.println("Largest & 2nd largest: " + Arrays.toString(largestAndSecondLargest(n)));
        System.out.println("Smallest & 2nd smallest: " + Arrays.toString(smallestAndSecondSmallest(n)));
    }
}
