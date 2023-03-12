package geeksForGeeks.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] rows = new int[]{0, 0, +1, -1};
        int[] cols = new int[]{+1, -1, 0, 0};
        // int[] rows = new int[]{0, 0, 1, -1, 1,1,-1,-1};
        // int[] cols = new int[]{1,-1, 0,  0, 1,-1,+1,-1};
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    Queue<CellInfo> queue = new LinkedList<>();
                    queue.add(new CellInfo(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        CellInfo cur = queue.poll();
                        int r = cur.row;
                        int c = cur.col;
                        for (int k = 0; k < 4; k++) {  //8 if diagonal allowed
                            if ((r + rows[k]) > -1
                                    && (c + cols[k]) > -1
                                    && (r + rows[k]) < row && (c + cols[k]) < col
                                    && !visited[r + rows[k]][c + cols[k]]
                                    && grid[r + rows[k]][c + cols[k]] == '1') {
                                queue.add(new CellInfo(r + rows[k], c + cols[k]));
                                visited[r + rows[k]][c + cols[k]] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
