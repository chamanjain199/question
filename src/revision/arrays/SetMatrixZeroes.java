package revision.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean isRowZero = false;
        boolean isColZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                isRowZero = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (isRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (isColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
