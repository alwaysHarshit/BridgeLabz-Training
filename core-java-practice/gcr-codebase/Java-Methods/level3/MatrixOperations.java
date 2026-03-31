import java.util.Random;
import java.util.Arrays;

public class MatrixOperations {
    public static int[][] randomMatrix(int n) {
        int[][] mat = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    public static int[][] transpose(int[][] mat) {
        int n = mat.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                t[j][i] = mat[i][j];
        return t;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    public static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1]/(double)det;
        inv[0][1] = -m[0][1]/(double)det;
        inv[1][0] = -m[1][0]/(double)det;
        inv[1][1] = m[0][0]/(double)det;
        return inv;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) System.out.println(Arrays.toString(row));
    }
    public static void printMatrix(double[][] mat) {
        for (double[] row : mat) System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] m2 = randomMatrix(2);
        System.out.println("2x2 Matrix:"); printMatrix(m2);
        System.out.println("Transpose:"); printMatrix(transpose(m2));
        System.out.println("Determinant: " + determinant2x2(m2));
        double[][] inv2 = inverse2x2(m2);
        System.out.println("Inverse:");
        if (inv2 != null) printMatrix(inv2); else System.out.println("Not invertible");
        int[][] m3 = randomMatrix(3);
        System.out.println("3x3 Matrix:"); printMatrix(m3);
        System.out.println("Transpose:"); printMatrix(transpose(m3));
        System.out.println("Determinant: " + determinant3x3(m3));
        // Inverse for 3x3 not implemented for brevity
    }
}
