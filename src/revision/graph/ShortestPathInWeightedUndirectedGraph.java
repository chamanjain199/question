package revision.graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        List<List<List<Integer>>> adj = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int[] arr = edges[i];
            adj.get(arr[0]).add(List.of(arr[1], arr[2]));
            adj.get(arr[1]).add(List.of(arr[0], arr[2]));
        }
        int[] minWeight = new int[n + 1];
        Arrays.fill(minWeight, Integer.MAX_VALUE);
        minWeight[1] = 0;
        int[] pathMemo = new int[n + 1];
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.second));
        queue.add(new Pair(1, 0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            List<List<Integer>> children = adj.get(node.first);
            for (List<Integer> ed : children) {
                int totalWeight = ed.get(1) + node.second;
                if (totalWeight < minWeight[ed.get(0)]) {
                    minWeight[ed.get(0)] = totalWeight;
                    pathMemo[ed.get(0)] = node.first;
                    queue.add(new Pair(ed.get(0), totalWeight));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (minWeight[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }
        ans.add(n);

        int path = pathMemo[n];
        while (path != 0) {
            ans.add(0,path);
            path = pathMemo[path];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 5, 12},
                {2, 4, 140},
                {2, 10, 149},
                {3 ,6 ,154},
                {3, 7 ,9},
                {3, 8 ,226},
                {3, 10, 132},
                {4, 10, 55},
                {5, 8 ,33},
                {7, 8, 173}
        };
        System.out.println(shortestPath(10, 10, input));
    }
}
;