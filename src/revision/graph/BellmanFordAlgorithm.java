package revision.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int n1 = edge.get(0);
                int n2 = edge.get(1);
                int w = edge.get(2);
                if (dist[n1] != (int) 1e8 && dist[n1] + w < dist[n2]) {
                    dist[n2] = dist[n1] + w;
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int w = edge.get(2);
            if (dist[n1] != (int) 1e8 && dist[n1] + w < dist[n2]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
