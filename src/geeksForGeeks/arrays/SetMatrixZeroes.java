package geeksForGeeks.arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isRowZero = false;
        boolean isColZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                isRowZero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (isRowZero)
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        if (isColZero)
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][] {{1},{0}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("" + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("" + arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
