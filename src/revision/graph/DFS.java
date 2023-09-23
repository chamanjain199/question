package revision.graph;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(ans, adj, 0, visited);
        return ans;
    }

    private void dfs(ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        ArrayList<Integer> edges = adj.get(node);
        ans.add(node);
        visited[node] = true;
        for (Integer e : edges) {
            if (!visited[e]) {
                dfs(ans, adj, e, visited);
            }
        }
    }
}
