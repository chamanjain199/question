package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;

public class TopologicalSort {
    public static void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> topologyStack) {
        visited[s] = true;
        ArrayList<Integer> children = adj.get(s);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(child, adj, visited, topologyStack);
            }
        }
        topologyStack.push(s);
    }

    static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> topologyStack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, topologyStack);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!topologyStack.isEmpty()) {
            ans[i] = topologyStack.pop();
            i++;
        }
        return ans;
    }

    static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                inDegree[child]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[V];
        int count = 0;
        while (!queue.isEmpty()) {
            int curVertex = queue.poll();
            ArrayList<Integer> children = adj.get(curVertex);
            ans[count++] = curVertex;
            for (Integer child : children) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
