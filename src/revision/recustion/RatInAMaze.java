package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    static int[][] covered;
    static ArrayList<String> paths;

    public static ArrayList<String> findPath(int[][] m, int n) {
        paths = new ArrayList<>();
        if (m[0][0] == 0) {
            paths.add("-1");
            return paths;
        }
        covered = new int[n][n];
        covered[0][0] = 1;
        findPathRec(m, n-1, 0, 0, new StringBuilder());
        return paths;

    }

    public static void findPathRec(int[][] m, int n, int i, int j, StringBuilder path) {
        if (i == n && j == n) {
            paths.add(path.toString());
            return;
        }
        if (i > 0 && covered[i - 1][j] == 0 && m[i - 1][j] == 1) {
            covered[i - 1][j] = 1;
            path.append("U");
            findPathRec(m, n, i - 1, j, path);
            path.deleteCharAt(path.length() - 1);
            covered[i - 1][j] = 0;
        }
        if (i < n && covered[i + 1][j] == 0 && m[i + 1][j] == 1) {
            covered[i + 1][j] = 1;
            path.append("D");
            findPathRec(m, n, i + 1, j, path);
            path.deleteCharAt(path.length() - 1);
            covered[i + 1][j] = 0;
        }
        if (j > 0 && covered[i][j - 1] == 0 && m[i][j - 1] == 1) {
            covered[i][j - 1] = 1;
            path.append("L");
            findPathRec(m, n, i, j - 1, path);
            path.deleteCharAt(path.length() - 1);
            covered[i][j - 1] = 0;
        }
        if (j < n  && covered[i][j + 1] == 0 && m[i][j + 1] == 1) {
            covered[i][j + 1] = 1;
            path.append("R");
            findPathRec(m, n, i, j + 1, path);
            path.deleteCharAt(path.length() - 1);
            covered[i][j + 1] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(m,4));
    }
}
