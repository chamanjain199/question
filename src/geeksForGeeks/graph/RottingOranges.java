package geeksForGeeks.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.SocketHandler;



public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<CellInfo> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new CellInfo(i, j, 0));
                }
            }
        }

        int[] rows = new int[]{0, 0, +1, -1};
        int[] cols = new int[]{+1, -1, 0, 0};
        int totalTime = 0;
        while (!queue.isEmpty()) {
            CellInfo cur = queue.poll();
            int r = cur.row;
            int c = cur.col;
            for (int i = 0; i < 4; i++) {
                if ((r + rows[i]) > -1 && (c + cols[i]) > -1 && (r + rows[i]) < row && (c + cols[i]) < col && grid[r + rows[i]][c + cols[i]] == 1) {
                    queue.add(new CellInfo(r + rows[i], c + cols[i], cur.time + 1));
                    grid[r + rows[i]][c + cols[i]] = 2;
                    totalTime = Math.max(totalTime, cur.time + 1);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {

        System.out.println(orangesRotting(new int[][]{{1}}));

    }
}
