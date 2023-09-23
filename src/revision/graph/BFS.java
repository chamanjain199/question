package revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            ans.add(node);
            ArrayList<Integer> edges = adj.get(node);
            for (Integer e : edges) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                }
            }
        }
        return ans;
    }

}
