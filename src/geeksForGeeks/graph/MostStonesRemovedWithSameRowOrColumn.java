package geeksForGeeks.graph;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public static int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int row = stones.length;
        for (int i = 0; i < row; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet disjointSet = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> stoneNode = new HashSet<>();
        int nodeRow, nodeCol;
        for (int i = 0; i < row; i++) {
            nodeRow = stones[i][0];
            nodeCol = stones[i][1] + maxRow + 1;
            disjointSet.unionByRank(nodeRow, nodeCol);
            stoneNode.add(nodeRow);
            stoneNode.add(nodeCol);
        }
        int count = 0;
        for (Integer node : stoneNode) {
            if (disjointSet.findUParent(node) == node) {
                count++;
            }
        }
        return row - count;
    }

    public static void main(String[] args) {

        System.out.println(removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}}));

    }
}