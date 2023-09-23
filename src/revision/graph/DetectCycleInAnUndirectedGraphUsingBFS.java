package revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInAnUndirectedGraphUsingBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited= new boolean[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {
                if (detectCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int i, ArrayList<ArrayList<Integer>> prerequisites, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, -1));
        visited[i] = true;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int n = node.first;
            int p = node.second;
            ArrayList<Integer> edges = prerequisites.get(n);
            for (Integer edge : edges) {
                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(new Pair(edge, n));
                } else if (edge != p) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInAnUndirectedGraphUsingBFS obj = new DetectCycleInAnUndirectedGraphUsingBFS();
        int input[][] = {{2,1},{3,1}};



        System.out.println(obj.canFinish(input.length+1, input));
    }
}
