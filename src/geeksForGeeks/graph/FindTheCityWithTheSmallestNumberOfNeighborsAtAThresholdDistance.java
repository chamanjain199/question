package geeksForGeeks.graph;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] floydwarshall = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    floydwarshall[i][j] = 0;
                } else {
                    floydwarshall[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] child : edges) {
            int u = child[0];
            int v = child[1];
            int wt = child[2];
            floydwarshall[u][v] = wt;
            floydwarshall[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (floydwarshall[i][k] != Integer.MAX_VALUE && floydwarshall[k][j] != Integer.MAX_VALUE)
                        floydwarshall[i][j] = Math.min(floydwarshall[i][j], floydwarshall[i][k] + floydwarshall[k][j]);
                }
            }
        }
        int minNode = n;
        int minCity = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (floydwarshall[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count < minCity) {
                minCity = count;
                minNode = i;
            }
        }
        return minNode;
    }

    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
    }
}
