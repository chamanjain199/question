package revision.graph;

import java.util.*;

public class DijkstraAlgorithmPriorityQueue {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
                return Integer.compare(o1.second, o2.second);
        });
        queue.add(new Pair(S, 0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            for (ArrayList<Integer> edges : adj.get(node.first)) {
                int nodeIndex = edges.get(0);
                int nodeWeight = edges.get(1);
                int totalNodeWeight = node.second + nodeWeight;
                if (totalNodeWeight < ans[nodeIndex]) {
                    ans[nodeIndex] = totalNodeWeight;
                    queue.add(new Pair(nodeIndex, totalNodeWeight));
                }
            }
        }
        return ans;
    }
    static int[] dijkstra2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.second, o2.second);
        });
        queue.add(new Pair(S, 0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            for (ArrayList<Integer> edges : adj.get(node.first)) {
                int nodeIndex = edges.get(0);
                int nodeWeight = edges.get(1);
                int totalNodeWeight = node.second + nodeWeight;
                if (totalNodeWeight < ans[nodeIndex]) {
                    if (ans[nodeIndex] != Integer.MAX_VALUE) {
                        queue.removeIf(x -> x.first == node.first);
                    }
                    ans[nodeIndex] = totalNodeWeight;
                    queue.add(new Pair(nodeIndex, totalNodeWeight));
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> input = new ArrayList<>();
        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        ArrayList<Integer> node = new ArrayList<>();
        node.add(1);
        node.add(9);
        input1.add(node);
        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        ArrayList<Integer> node2 = new ArrayList<>();
        node2.add(0);
        node2.add(9);
        input2.add(node2);
        input.add(input1);
        input.add(input2);
        System.out.println(Arrays.toString(dijkstra(2, input, 0)));

    }
}
