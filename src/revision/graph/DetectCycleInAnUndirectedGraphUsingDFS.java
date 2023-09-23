package revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInAnUndirectedGraphUsingDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1,adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int i, int parent, ArrayList<ArrayList<Integer>> prerequisites, boolean[] visited) {

        visited[i] = true;
        ArrayList<Integer> edges = prerequisites.get(i);
        for (Integer edge : edges) {
            if (!visited[edge]) {
                visited[edge] = true;
                if (detectCycle(edge, i, prerequisites, visited)) {
                    return true;
                }

            } else if (edge != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInAnUndirectedGraphUsingDFS obj = new DetectCycleInAnUndirectedGraphUsingDFS();
        int input[][] = {{1, 2}, {2, 3}};


        System.out.println(obj.canFinish(input.length + 1, input));
    }
}
