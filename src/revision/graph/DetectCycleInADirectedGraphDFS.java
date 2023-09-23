package revision.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInADirectedGraphDFS {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[n + 1];
        boolean[] visitedDFS = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> arr : edges) {
            adj.get(arr.get(0)).add(arr.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (detectCycleInDirectedGraphRec(i,  adj, visited, visitedDFS)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleInDirectedGraphRec(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] visitedDFS) {
        visited[i] = true;
        visitedDFS[i] = true;
        ArrayList<Integer> edges = adj.get(i);
        for (Integer edge : edges) {
            if (!visited[edge]) {
                if (detectCycleInDirectedGraphRec(edge, adj, visited, visitedDFS)) return true;
            } else if (visitedDFS[edge]) {
                return true;
            }
        }
        visitedDFS[i] = false;
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(4, 5)));
        adj.add(new ArrayList<>(Arrays.asList(5, 9)));
        adj.add(new ArrayList<>(Arrays.asList(5, 10)));
        adj.add(new ArrayList<>(Arrays.asList(5, 1)));
        adj.add(new ArrayList<>(Arrays.asList(5, 3)));
        adj.add(new ArrayList<>(Arrays.asList(6, 7)));
        System.out.println( detectCycleInDirectedGraph(10, adj));
    }
}
