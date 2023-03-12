package geeksForGeeks.graph;

import java.util.*;

public class DijkstraAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        priorityQueue.add(new Pair(S, 0));
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            ArrayList<ArrayList<Integer>> children = adj.get(cur.node);
            for (ArrayList<Integer> child : children) {
                int node = child.get(0);
                int weight = child.get(1);
                if ((cur.weight + weight) < ans[node]) {
                    if (ans[node] != Integer.MAX_VALUE) {
                        priorityQueue.removeIf(x -> x.node == node);
                    }
                    priorityQueue.add(new Pair(node, cur.weight + weight));
                    ans[node] = cur.weight + weight;

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
