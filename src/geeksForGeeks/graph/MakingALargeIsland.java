package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    int[] rowsIndex = new int[]{0, 0, +1, -1};
    int[] colsIndex = new int[]{+1, -1, 0, 0};

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DisjointSet disjointSet = new DisjointSet(row * col);
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int u = i * col + j;
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int r = i + rowsIndex[k];
                        int c = j + colsIndex[k];
                        if (r > -1 && c > -1 && r < row && c < col && grid[r][c] == 1) {
                            int v = r * col + c;
                            disjointSet.unionBySize(u, v);
                        }
                    }
                }
            }
        }

        int maxIsLand = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;
                    Set<Integer> parentSet = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int r = i + rowsIndex[k];
                        int c = j + colsIndex[k];
                        if (r > -1 && c > -1 && r < row && c < col && grid[r][c] == 1) {
                            int v = r * col + c;
                            int parent = disjointSet.findUParent(v);
                            if (parentSet.add(parent)) {
                                count += disjointSet.sizes.get(parent);
                            }
                        }
                    }
                    maxIsLand = Math.max(maxIsLand, count);
                }
            }
        }
        if (maxIsLand == 0) {
            return row * col;
        }
        return maxIsLand;
    }


    public static void main(String[] args) {

    }
}
