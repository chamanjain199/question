package revision.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] rows = {0, 0, 1, -1};
        int[] cols = {-1, 1, 0, 0};
        int count = 0;
        Queue<Pair> queue;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    queue = new LinkedList<>();
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int i1 = pair.first;
                        int i2 = pair.second;
                        for (int k = 0; k < 4; k++) {
                            int r = rows[k] + i1;
                            int c = cols[k] + i2;
                            if (r > -1 && r < row && c > -1 && c < col && !visited[r][c] && grid[r][c] == '1') {
                                visited[r][c] = true;
                                queue.add(new Pair(r, c));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
