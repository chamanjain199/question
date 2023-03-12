package geeksForGeeks.graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    static int countPaths(int n, List<List<Integer>> roads) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> child : roads) {
            adj.get(child.get(0)).add(new Pair(child.get(1), child.get(2)));
            adj.get(child.get(1)).add(new Pair(child.get(0), child.get(2)));
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        priorityQueue.add(new Pair(0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            List<Pair> children = adj.get(cur.node);
            for (Pair child : children) {
                int newWeight = cur.weight + child.weight;
                if (newWeight < dist[child.node]) {
                    dist[child.node] = newWeight;
                    priorityQueue.add(new Pair(child.node, newWeight));
                    ways[child.node] = ways[cur.node];
                } else if (newWeight == dist[child.node]) {
                    ways[child.node] = (ways[child.node] + ways[cur.node]);

                }
            }
        }
        return ways[n - 1];

    }

    public static void main(String[] args) {

    }
}
