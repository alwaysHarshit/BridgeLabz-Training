import java.util.Arrays;

public class NumberCheckerUtility2 {
    public static int[] digitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        for (int d : digitsArray(n)) sum += d;
        return sum;
    }

    public static int sumOfSquares(int n) {
        int sum = 0;
        for (int d : digitsArray(n)) sum += d * d;
        return sum;
    }

    public static boolean isHarshad(int n) {
        return n % sumOfDigits(n) == 0;
    }

    public static int[][] digitFrequency(int n) {
        int[] arr = digitsArray(n);
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : arr) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int n = 6804;
        System.out.println("Number: " + n);
        System.out.println("Sum of digits: " + sumOfDigits(n));
        System.out.println("Sum of squares: " + sumOfSquares(n));
        System.out.println("Harshad number: " + isHarshad(n));
        System.out.println("Digit frequency:");
        int[][] freq = digitFrequency(n);
        for (int[] row : freq) {
            if (row[1] > 0) System.out.println(row[0] + ": " + row[1]);
        }
    }
}
