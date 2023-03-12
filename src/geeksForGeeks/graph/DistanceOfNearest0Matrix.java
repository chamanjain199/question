package geeksForGeeks.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearest0Matrix {
    public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<CellInfo> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new CellInfo(i, j));
                }
            }
        }

        int[] rows = new int[]{0, 0, +1, -1};
        int[] cols = new int[]{+1, -1, 0, 0};
        while (!queue.isEmpty()) {
            CellInfo cur = queue.poll();
            int r = cur.row;
            int c = cur.col;
            int val = mat[r][c];
            for (int i = 0; i < 4; i++) {
                if ((r + rows[i]) > -1 && (c + cols[i]) > -1 && (r + rows[i]) < row && (c + cols[i]) < col && !visited[r + rows[i]][c + cols[i]]) {
                    queue.add(new CellInfo(r + rows[i], c + cols[i]));
                    visited[r + rows[i]][c + cols[i]] = true;
                    mat[r + rows[i]][c + cols[i]] = val + 1;
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}})));
    }
}
