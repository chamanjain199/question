package revision.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraphBFS {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        int[] inDegree = new int[n + 1];
        inDegree[0] = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> arr : edges) {
            adj.get(arr.get(0)).add(arr.get(1));
        }
        for (int i = 1; i <= n; i++) {
            for (Integer edge : adj.get(i)) {
                inDegree[edge]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int topoSize = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSize++;
            for (Integer e : adj.get(node)) {
                inDegree[e]--;
                if (inDegree[e] == 0) {
                    queue.add(e);
                }
            }
        }
        return topoSize != n;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(2, 1)));
//        adj.add(new ArrayList<>(Arrays.asList(3, 4)));
//        adj.add(new ArrayList<>(Arrays.asList(4,5)));

        System.out.println(detectCycleInDirectedGraph(2, adj));
    }
}
