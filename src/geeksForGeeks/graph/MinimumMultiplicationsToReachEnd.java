package geeksForGeeks.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int num : arr) {
                int child = (num * cur.node) % 100000;
                if ((cur.weight + 1) < dist[child]) {
                    dist[child] = cur.weight + 1;
                    if (child == end) {
                        return dist[child];
                    }
                    queue.add(new Pair(child, cur.weight + 1));
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
