package geeksForGeeks.arrays;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.println("i "+i+ " j "+j);
                swap(i, j, matrix);
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(0, n-1, matrix[i]);
        }
    }

    public static void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void swapRow(int i, int j, int[] row) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

    public static void reverse(int low, int high, int[] row) {
        while (low < high) swapRow(low++, high--, row);
    }

    public static void main(String[] args) {

        int[][] matrix=new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));


    }
}
