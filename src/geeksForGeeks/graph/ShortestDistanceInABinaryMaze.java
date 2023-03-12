package geeksForGeeks.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dist = new int[row][col];
        for (int[] subArray : dist) {
            Arrays.fill(subArray, Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 0;
        Queue<GridPair> queue = new LinkedList<>();
        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};
        queue.add(new GridPair(source[0], source[1], 0));
        while (!queue.isEmpty()) {
            GridPair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = cur.row + rows[i];
                int c = cur.col + cols[i];
                if (r > -1 && r < row && c > -1 && c >= col && grid[r][c] == 1) {
                    if (cur.weight + 1 < (dist[r][c])) {
                        queue.add(new GridPair(r, c, cur.weight + 1));
                        dist[r][c] = cur.weight + 1;
                    }
                }
            }
        }
        if (dist[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[destination[0]][destination[1]];
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0]==1){
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dist = new int[row][col];
        for (int[] subArray : dist) {
            Arrays.fill(subArray, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        Queue<GridPair> queue = new LinkedList<>();
        int[] rows = {0, 0, 1, -1,-1,-1,1,1};
        int[] cols = {1, -1, 0, 0,-1, 1,-1,1};
        queue.add(new GridPair(0, 0, 1));
        while (!queue.isEmpty()) {
            GridPair cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int r = cur.row + rows[i];
                int c = cur.col + cols[i];
                if (r > -1 && r < row && c > -1 && c < col && grid[r][c] == 0) {
                    if (cur.weight + 1 < (dist[r][c])) {
                        queue.add(new GridPair(r, c, cur.weight + 1));
                        dist[r][c] = cur.weight + 1;
                    }
                }
            }
        }
        if (dist[row-1][col-1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[row-1][col-1];
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }
}
