package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsOnlineQuery {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int[][] island = new int[rows][cols];
        int k = operators.length;
        int[] rowsIndex = new int[]{0, 0, +1, -1};
        int[] colsIndex = new int[]{+1, -1, 0, 0};
        DisjointSet disjointSet = new DisjointSet(rows * cols);
        for (int i = 0; i < k; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (island[row][col] == 1) {
                ans.add(count);
                continue;
            }

            island[row][col] = 1;
            count++;
            int u = row * cols + col;
            for (int j = 0; j < 4; j++) {
                int r = row + rowsIndex[j];
                int c = col + colsIndex[j];
                if (r > -1 && c > -1 && r < rows && c < cols && island[r][c] == 1) {
                    int v = r * cols + c;
                    if (disjointSet.findUParent(u) != disjointSet.findUParent(v)) {
                        count--;
                        disjointSet.unionByRank(u, v);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
