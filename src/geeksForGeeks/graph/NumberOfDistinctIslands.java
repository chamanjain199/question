package geeksForGeeks.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands {
    static int countDistinctIslands(int[][] grid) {
        Set<String> uniqueSet = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] rows = new int[]{0, 0, +1, -1};
        int[] cols = new int[]{+1, -1, 0, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    Queue<CellInfo> queue = new LinkedList<>();
                    queue.add(new CellInfo(i, j));
                    StringBuilder sb = new StringBuilder();
                    sb.append(0).append(0);
                    while (!queue.isEmpty()) {
                        CellInfo cur = queue.poll();
                        int r = cur.row;
                        int c = cur.col;
                        for (int k = 0; k < 4; k++) {
                            if ((r + rows[k]) > -1
                                    && (c + cols[k]) > -1
                                    && (r + rows[k]) < row && (c + cols[k]) < col
                                    && !visited[r + rows[k]][c + cols[k]]
                                    && grid[r + rows[k]][c + cols[k]] == 1) {
                                queue.add(new CellInfo(r + rows[k], c + cols[k]));
                                sb.append((r + rows[k] - i));
                                sb.append((c + cols[k] - j));
                                visited[r + rows[k]][c + cols[k]] = true;
                            }
                        }
                    }
                    uniqueSet.add(sb.toString());
                }
            }
        }
        return uniqueSet.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinctIslands(new int[][] {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}}));

    }
}
