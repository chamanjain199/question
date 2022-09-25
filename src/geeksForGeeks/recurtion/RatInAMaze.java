package geeksForGeeks.recurtion;

import java.util.ArrayList;

public class RatInAMaze {
    static int covered[][];
    static ArrayList<String> allPaths;

    public static ArrayList<String> findPath(int[][] m, int n) {
        covered = new int[n][n];
        covered[0][0] = 1;
        allPaths = new ArrayList<>();
        findPathHelper(m, new StringBuilder(), 0, 0, n - 1);
        return allPaths;
    }

    private static void findPathHelper(int[][] m, StringBuilder coveredPath, int i, int j, int size) {
        if (i == size && j == size) {
            allPaths.add(coveredPath.toString());
            return;
        }
        if (i < size && covered[i + 1][j] == 0 && m[i + 1][j] == 1) {
            covered[i + 1][j] = 1;
            findPathHelper(m, coveredPath.append("D"), i + 1, j, size);
            coveredPath.deleteCharAt(coveredPath.length() - 1);
            covered[i + 1][j] = 0;
        }
        if (j < size && covered[i][j + 1] == 0 && m[i][j + 1] == 1) {
            covered[i][j + 1] = 1;
            findPathHelper(m, coveredPath.append("R"), i, j + 1, size);
            coveredPath.deleteCharAt(coveredPath.length() - 1);
            covered[i][j + 1] = 0;
        }
        if (j > 0 && covered[i][j - 1] == 0 && m[i][j - 1] == 1) {
            covered[i][j - 1] = 1;
            findPathHelper(m, coveredPath.append("L"), i, j - 1, size);
            coveredPath.deleteCharAt(coveredPath.length() - 1);
            covered[i][j - 1] = 0;
        }
        if (i > 0 && covered[i - 1][j] == 0 && m[i - 1][j] == 1) {
            covered[i - 1][j] = 1;
            findPathHelper(m, coveredPath.append("U"), i - 1, j, size);
            coveredPath.deleteCharAt(coveredPath.length() - 1);
            covered[i - 1][j] = 0;
        }
    }

    public static void main(String[] args) {
        int input[][] = new int[][]{{0, 1, 1, 1},
                {1, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 1, 1}};
        int n = 2;
        System.out.println(findPath(input, n));
    }
}
