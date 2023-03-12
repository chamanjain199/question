package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;

        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> child : edges) {
                int u = child.get(0);
                int v = child.get(1);
                int wt = child.get(2);
                if (ans[u] != Integer.MAX_VALUE && (ans[u] + wt) < ans[v]) {
                    ans[v] = ans[u] + wt;
                }
            }
        }
        for (ArrayList<Integer> child : edges) {
            int u = child.get(0);
            int v = child.get(1);
            int wt = child.get(2);
            if (ans[u] != Integer.MAX_VALUE && (ans[u] + wt) < ans[v]) {
                return new int[]{-1};
            }
        }
        return ans;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int[] child : edges) {
                int u = child[0];
                int v = child[1];
                int wt = child[2];
                if (ans[u] != Integer.MAX_VALUE && (ans[u] + wt) < ans[v]) {
                    ans[v] = ans[u] + wt;
                }
            }
        }
        for (int[] child : edges) {
            int u = child[0];
            int v = child[1];
            int wt = child[2];
            if (ans[u] != Integer.MAX_VALUE && (ans[u] + wt) < ans[v]) {
                return 1;
            }
        }
        return 0;
    }
}
