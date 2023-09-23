package revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSortBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer e : adj.get(i)) {
                inDegree[e]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            topo[i++] = node;
            ArrayList<Integer> edges = adj.get(node);
            for (Integer edge : edges) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        return topo;
    }
}
