package revision.graph;

import java.util.*;

public class MinimumSpanningTreePrimsAlgo {
    static int spanningTree(int V, int E, int edges[][]) {
        List<List<List<Integer>>> adj = new ArrayList<>(V);
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            int[] arr = edges[i];
            adj.get(arr[0]).add(List.of(arr[1], arr[2]));
            adj.get(arr[1]).add(List.of(arr[0], arr[2]));
        }
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.first, o2.first);
        });
        boolean[] visited = new boolean[V];
        int sum = 0;
        queue.add(new Pair(0, 0, -1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited[pair.second]) continue;
            visited[pair.second] = true;
            sum += pair.first;
            for (List<Integer> edgePair : adj.get(pair.second)) {
                if (!visited[edgePair.get(0)]) {
                    queue.add(new Pair(edgePair.get(1), edgePair.get(0), pair.second));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
