package revision.graph;

import java.util.PriorityQueue;

public class MSTKrushkalAlgo {
    static int spanningTree(int V, int E, int edges[][]) {
        DisjointSet ds = new DisjointSet(V);
        PriorityQueue<Pair> queue = new PriorityQueue<>(((o1, o2) -> {
            return Integer.compare(o1.first, o2.first);
        }));
        for (int[] arr : edges) {
            queue.add(new Pair(arr[2], arr[0], arr[1]));
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int p1 = ds.findUParent(pair.second);
            int p2 = ds.findUParent(pair.third);
            if (p1 != p2) {
                ds.unionByRank(pair.second, pair.third);
                sum += pair.first;
            }
        }
        return sum;
    }
}
