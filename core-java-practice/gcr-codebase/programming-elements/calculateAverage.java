import java.util.Arrays;
import java.util.Scanner;

public class calculateAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the "+ (i+1)+" element");
            arr[i] = sc.nextInt();
        }
        int avg=calAvg(arr,n);
        System.out.println("The avg is:"+avg);
    }

    private static int calAvg(int[] arr,int n) {
        int sumOfElement = Arrays.stream(arr).sum();
        return sumOfElement / n;
    }
}
