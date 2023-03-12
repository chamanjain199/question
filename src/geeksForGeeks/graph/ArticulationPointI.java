package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointI {
    int timer = 1;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] mark = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, tin, low, mark);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i]) {
                arrayList.add(i);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(-1);
        }
        return arrayList;

    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin, int[] low, boolean[] mark) {

        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        ArrayList<Integer> children = adj.get(node);
        int totalChild = 0;
        for (Integer child : children) {
            if (child == parent) continue;
            if (!visited[child]) {
                dfs(child, node, adj, visited, tin, low, mark);
                low[node] = Math.min(low[child], low[node]);
                if (low[child] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }
                totalChild++;
            } else {
                low[node] = Math.min(tin[child], low[node]);
            }
        }
        if (totalChild > 1 && parent == -1) {
            mark[node] = true;
        }
    }

    public static void main(String[] args) {

    }
}
