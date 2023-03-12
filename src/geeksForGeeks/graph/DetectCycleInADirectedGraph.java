package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] callStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && DFSRec(visited, i, adj, callStack)) return true;
        }
        return false;
    }

    private boolean DFSRec(boolean[] visited, int src, ArrayList<ArrayList<Integer>> adj, boolean[] callStack) {
        visited[src] = true;
        callStack[src] = true;
        ArrayList<Integer> neighbours = adj.get(src);
        for (Integer neighbour : neighbours) {
            if (callStack[neighbour]) {
                return true;
            }
            if (!visited[neighbour]) {
                if (DFSRec(visited, neighbour, adj, callStack)) {
                    return true;
                }
            }
        }
        callStack[src] = false;
        return false;
    }

    public boolean isCyclic2(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                inDegree[child]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curVertex = queue.poll();
            count++;
            ArrayList<Integer> children = adj.get(curVertex);
            for (Integer child : children) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        return count != V;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean vis[] = new boolean[prerequisites.length];
        int courses[] = new int[numCourses];
        boolean flag = true;
        for(int pre[] : prerequisites) {
            courses[pre[1]]++;
        }
        while(flag) {
            flag = false;
            for(int i = 0; i < prerequisites.length; i++) {
                if(vis[i] == false) {
                    if(courses[prerequisites[i][0]] == 0) {
                        courses[prerequisites[i][1]]--;
                        vis[i] = true;
                        flag = true;
                    }
                }
            }
        }
        for(int i : courses) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }
}
