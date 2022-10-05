package geeksForGeeks.arrays;

import java.util.Arrays;

public class UniquePaths {

    public static int uniquePathsDP(int m, int n) {
        int[][] mapping = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mapping[i], -1);
        }
        return totalPath(0, 0, n, m, mapping);
    }

    private static int totalPath(int i, int j, int m, int n, int[][] mapping) {
        if (i == (n - 1) && j == (m - 1)) {
            return 1;
        }
        if (i >= n || j >= m) {
            return 0;
        }
        int count = 0;
        if (mapping[i][j] != -1) {
            return mapping[i][j];
        } else {
            count = totalPath(i + 1, j, m, n, mapping) + totalPath(i, j + 1, m, n, mapping);
            mapping[i][j] = count;
            return count;
        }

    }

    public static int uniquePathsOptimal(int m, int n) {
        double N = m + n - 2;
        int r = Math.min(n, m) - 1;
        double upper=1;
        double lower=1;
        for (double i = 0; i < r; i++) {
            upper*=(N-i);
            lower*=(i+1);
        }
        return (int)(upper/lower);
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsOptimal(9, 8));
    }
}
