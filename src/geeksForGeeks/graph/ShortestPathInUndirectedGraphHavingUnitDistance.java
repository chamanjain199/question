package geeksForGeeks.graph;

import java.util.*;

public class ShortestPathInUndirectedGraphHavingUnitDistance {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> children = adj.get(cur);
            for (int child : children) {
                if ((ans[cur] + 1) < ans[child]) {
                    ans[child] = ans[cur] + 1;
                    queue.add(child);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
