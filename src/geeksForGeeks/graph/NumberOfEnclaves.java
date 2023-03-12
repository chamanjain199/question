package geeksForGeeks.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<CellInfo> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                queue.add(new CellInfo(i, 0));
            }
            if (grid[i][col - 1] == 1) {
                visited[i][col - 1] = true;
                queue.add(new CellInfo(i, col - 1));
            }

        }
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                visited[0][i] = true;
                queue.add(new CellInfo(0, i));
            }
            if (grid[row - 1][i] == 1) {
                visited[row - 1][i] = true;
                queue.add(new CellInfo(row - 1, i));
            }
        }
        int[] rows = new int[]{0, 0, +1, -1};
        int[] cols = new int[]{+1, -1, 0, 0};
        while (!queue.isEmpty()) {
            CellInfo cur = queue.poll();
            int r = cur.row;
            int c = cur.col;
            for (int i = 0; i < 4; i++) {
                if ((r + rows[i]) > -1 && (c + cols[i]) > -1 && (r + rows[i]) < row && (c + cols[i]) < col && !visited[r + rows[i]][c + cols[i]] && grid[r + rows[i]][c + cols[i]] == 1) {
                    queue.add(new CellInfo(r + rows[i], c + cols[i]));
                    visited[r + rows[i]][c + cols[i]] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
