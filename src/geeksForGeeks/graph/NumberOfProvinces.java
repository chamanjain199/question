package geeksForGeeks.graph;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        DisjointSet disjointSet = new DisjointSet(v);
        for (int i = 0; i < v; i++) {
            for (int j = i; j < v; j++) {
                if(isConnected[i][j]==1)
                    disjointSet.unionByRank(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (disjointSet.findUParent(i) == i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
