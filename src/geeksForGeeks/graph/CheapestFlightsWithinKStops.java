package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WeightAndStop {
    int weight;
    int stop;

    int node;

    public WeightAndStop(int weight, int stop, int node) {
        this.weight = weight;
        this.stop = stop;
        this.node = node;
    }

    @Override
    public String toString() {
        return "WeightAndStop{" +
                "weight=" + weight +
                ", stop=" + stop +
                ", node=" + node +
                '}';
    }
}

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] child : flights) {
            adj.get(child[0]).add(new Pair(child[1], child[2]));
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Queue<WeightAndStop> queue = new LinkedList<>();
        queue.add(new WeightAndStop(0, 0, src));
        while (!queue.isEmpty()) {
            WeightAndStop cur = queue.poll();
            int stop = cur.stop;
            int weight = cur.weight;
            int node = cur.node;
            List<Pair> children = adj.get(node);
            if (stop <= k) {
                for (Pair child : children) {
                    int newWeight = weight + child.weight;
                    if (newWeight < dist[child.node]) {
                        queue.add(new WeightAndStop(newWeight, stop + 1, child.node));
                        dist[child.node] = newWeight;
                        System.out.println(queue);
                    }
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }


        return dist[dst];
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(5, new int[][]{{0, 1, 5}, {0, 3, 2}, {3, 1, 2}, {1, 2, 5}, {1, 4, 1}, {4, 2, 1}, {1, 2, 1}}, 0, 2, 2));
    }

}
