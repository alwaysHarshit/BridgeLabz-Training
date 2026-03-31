import java.util.Arrays;

public class FootballTeamHeights {
    // Generate random heights for 11 players
    public static int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101); // 150 to 250
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static double mean(int[] arr) {
        return sum(arr) / (double) arr.length;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights();
        System.out.println("Player heights: " + Arrays.toString(heights));
        System.out.println("Shortest height: " + min(heights));
        System.out.println("Tallest height: " + max(heights));
        System.out.printf("Mean height: %.2f\n", mean(heights));
    }
}
