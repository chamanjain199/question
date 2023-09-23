package revision.graph;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnectionsInANetwork {
    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> ed : connections) {
            adj.get(ed.get(0)).add(ed.get(1));
            adj.get(ed.get(1)).add(ed.get(0));
        }

        int[] lowestParent = new int[n];
        int[] toi = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, lowestParent, toi, bridges, visited);
            }
        }
        return bridges;
    }

    private void dfs(int i, int parent, List<List<Integer>> adj, int[] lowParent, int[] toi, List<List<Integer>> bridges, boolean[] visited) {
        visited[i] = true;
        lowParent[i] = timer;
        toi[i]=timer;
        timer++;
        for (Integer edge : adj.get(i)) {
            if (edge == parent) continue;
            if (!visited[edge]) {
                dfs(edge, i, adj, lowParent,toi, bridges, visited);
                lowParent[i] = Math.min(lowParent[i], lowParent[edge]);
                if (lowParent[edge] > toi[i]) {
                    bridges.add(List.of(i, edge));
                }
            } else {
                lowParent[i] = Math.min(lowParent[i], lowParent[edge]);
            }
        }
    }
    public static void main(String[] args) {
        CriticalConnectionsInANetwork obj = new CriticalConnectionsInANetwork();
        List<List<Integer>> input = List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3));
        System.out.println(obj.criticalConnections(input.size(), input));
    }
}
