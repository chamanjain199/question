package geeksForGeeks.graph;

import java.util.*;

public interface ShortestPathInWeightedUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] child : edges) {
            adj.get(child[0]).add(new Pair(child[1], child[2]));
            adj.get(child[1]).add(new Pair(child[0], child[2]));
        }
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        priorityQueue.add(new Pair(1, 0));
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            List<Pair> children = adj.get(cur.node);
            for (Pair child : children) {
                if ((cur.weight + child.weight) < (dist[child.node])) {
                    if (dist[child.node] != Integer.MAX_VALUE) {
                        priorityQueue.removeIf(x -> x.node == child.node);
                    }
                    dist[child.node] = (cur.weight + child.weight);
                    priorityQueue.add(new Pair(child.node, dist[child.node]));

                    parent[child.node] = cur.node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int parentIndex = n;
        while (parent[parentIndex] != parentIndex) {
            path.add(parentIndex);
            parentIndex = parent[parentIndex];
        }
        path.add(1);
        Collections.reverse(path);
        return path;


    }

    public static void main(String[] args) {

    }
}
