package geeksForGeeks.graph;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    public static int[] shortestPath(int N, int M, int[][] edges) {
        Stack<Integer> topologyStack = new Stack<>();
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, topologyStack);
            }
        }
        int[] ans = new int[N];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        while (!topologyStack.isEmpty()) {
            int cur = topologyStack.pop();
            List<Pair> children = adj.get(cur);
            for (Pair child : children) {
                ans[child.node] = Math.min(ans[child.node], ans[cur] + child.weight);
            }
        }
        for (int i = 0; i < N; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }

        }
        return ans;
    }

    public static void dfs(int s, boolean[] visited, List<List<Pair>> edges, Stack<Integer> stack) {
        visited[s] = true;
        List<Pair> children = edges.get(s);
        for (Pair child : children) {
            if (!visited[child.node]) {
                dfs(child.node, visited, edges, stack);
            }
        }
        stack.add(s);
    }

    public static int[] shortestPathOptimized(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] ans = new int[N];
        dfsOptimized(0, adj, ans);
        for (int i = 0; i < N; i++) {
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void dfsOptimized(int s, List<List<Pair>> edges, int[] ans) {
        List<Pair> children = edges.get(s);
        for (Pair child : children) {
            if (ans[child.node] != 0) {
                ans[child.node] = Math.min(ans[child.node], ans[s] + child.weight);
            } else {
                ans[child.node] = ans[s] + child.weight;
            }
            dfsOptimized(child.node, edges, ans);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPath(6, 7, new int[][]{{0, 1, 2}, {0, 4, 1}, {4, 5, 4}
                , {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}})));
    }
}
