package revision.graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, stack, visited);
        }
        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            transposeAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (Integer e : adj.get(i)) {
                transposeAdj.get(e).add(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!visited[i]) {
                count++;
                dfsTranspose(i, transposeAdj, visited);
            }
        }
        return count;
    }

    private void dfsTranspose(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (Integer e : adj.get(i)) {
            if (!visited[e]) {
                dfsTranspose(e, adj, visited);
            }
        }
    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        for (Integer e : adj.get(i)) {
            if (!visited[e]) {
                dfs(e, adj, stack, visited);
            }
        }
        stack.add(i);
    }
}
