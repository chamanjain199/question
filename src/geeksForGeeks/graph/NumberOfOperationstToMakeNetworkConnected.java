package geeksForGeeks.graph;

public class NumberOfOperationstToMakeNetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int availableCable = 0;
        int len = connections.length;
        for (int i = 0; i < len; i++) {
            if (disjointSet.findUParent(connections[i][0]) == disjointSet.findUParent(connections[i][1])) {
                availableCable++;
            } else {
                disjointSet.unionByRank(connections[i][0], connections[i][1]);
            }
        }
        int countDiffComponent = -1;
        for (int i = 0; i < n; i++) {
            if (disjointSet.findUParent(i) == i) {
                countDiffComponent++;
            }
        }
        if (availableCable >= countDiffComponent) {
            return countDiffComponent;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    }
}
