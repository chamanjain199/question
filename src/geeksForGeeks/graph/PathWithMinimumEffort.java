package geeksForGeeks.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for (int[] child : dist) {
            Arrays.fill(child, Integer.MAX_VALUE);
        }
        int[] rows = new int[]{0, 0, 1, -1};
        int[] cols = new int[]{1, -1, 0, 0};
        dist[0][0] = 0;
        PriorityQueue<GridPair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        priorityQueue.add(new GridPair(0, 0, 0));
        while (!priorityQueue.isEmpty()) {
            GridPair cur = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int r = cur.row + rows[i];
                int c = cur.col + cols[i];
                if (r > -1 && c > -1 && r < row && c < col) {
                    int diff = Math.abs(heights[cur.row][cur.col] - heights[r][c]);
                    diff = Math.max(dist[cur.row][cur.col], diff);
                    if (diff < dist[r][c]) {
                        dist[r][c] = diff;
                        priorityQueue.add(new GridPair(r, c, diff));
                    }
                }
            }
        }

        return dist[row - 1][col - 1];

    }

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }
}
