import java.util.Arrays;

public class NumberCheckerUtility3 {
    public static int[] digitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    public static boolean compareArrays(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int n) {
        int[] arr = digitsArray(n);
        return compareArrays(arr, reverseArray(arr));
    }

    public static boolean isDuckNumber(int n) {
        String s = String.valueOf(Math.abs(n));
        return s.substring(1).contains("0");
    }

    public static void main(String[] args) {
        int n = 12321;
        System.out.println("Number: " + n);
        System.out.println("Palindrome: " + isPalindrome(n));
        System.out.println("Duck number: " + isDuckNumber(n));
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        int[] arr3 = {3,2,1};
        System.out.println("Compare arr1 & arr2: " + compareArrays(arr1, arr2));
        System.out.println("Compare arr1 & arr3: " + compareArrays(arr1, arr3));
    }
}
