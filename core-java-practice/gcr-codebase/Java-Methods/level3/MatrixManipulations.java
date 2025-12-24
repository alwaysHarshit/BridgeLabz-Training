import java.util.Random;
import java.util.Arrays;

public class MatrixManipulations {
    public static int[][] randomMatrix(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    public static int[][] add(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                res[i][j] = a[i][j] - b[i][j];
        return res;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    res[i][j] += a[i][k] * b[k][j];
        return res;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] a = randomMatrix(2, 2);
        int[][] b = randomMatrix(2, 2);
        System.out.println("Matrix A:"); printMatrix(a);
        System.out.println("Matrix B:"); printMatrix(b);
        System.out.println("A + B:"); printMatrix(add(a, b));
        System.out.println("A - B:"); printMatrix(subtract(a, b));
        System.out.println("A * B:"); printMatrix(multiply(a, b));
    }
}
