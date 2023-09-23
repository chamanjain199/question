package revision.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, stack, visited);
            }
        }
        int[] ans = new int[V];
        int i = V - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        ArrayList<Integer> edges = adj.get(i);
        for (Integer edge : edges) {
            if (!visited[edge]) {
                dfs(edge, adj, stack, visited);
            }
        }
        stack.push(i);
    }
}
