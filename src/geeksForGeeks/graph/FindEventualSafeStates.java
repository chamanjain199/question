package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        boolean[] visited = new boolean[len];
        boolean[] currentPath = new boolean[len];
        Set<Integer> safeNodes = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(i, visited, currentPath, graph, safeNodes);
            }
        }
        return new ArrayList<>(safeNodes);

    }

    public static boolean dfs(int s, boolean[] visited, boolean[] currentPath, int[][] graph, Set<Integer> safeNode) {
        visited[s] = true;
        currentPath[s] = true;
        int[] children = graph[s];
        for (int child : children) {
            if (currentPath[child]) {
                return false;
            }
            if (!visited[child]) {
                if (!dfs(child, visited, currentPath, graph, safeNode)) return false;
            }
        }
        currentPath[s] = false;
        safeNode.add(s);
        return true;
    }
}
