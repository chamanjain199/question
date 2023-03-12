package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsInANetworkORTarjenAlgo {
    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> child : connections) {
            adj.get(child.get(0)).add(child.get(1));
            adj.get(child.get(1)).add(child.get(0));
        }
        boolean[] visited = new boolean[n];
        int[] tio = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, adj, visited, tio, low, bridges, -1);
        return bridges;

    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] tio, int[] low, List<List<Integer>> bridges, int parent) {

        visited[node] = true;
        low[node] = timer;
        tio[node] = timer;
        timer++;
        List<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (child == parent) continue;
            if (!visited[child]) {
                dfs(child, adj, visited, tio, low, bridges, node);
                low[node] = Math.min(low[node], low[child]);
                if (low[child] > tio[node]) {
                    bridges.add(List.of(child, node));
                }

            } else {
                low[node] = Math.min(low[node], low[child]);
            }

        }

    }
}
