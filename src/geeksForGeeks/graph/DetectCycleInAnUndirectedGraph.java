package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DetectCycleInAnUndirectedGraph {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(visited, i, adj, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(boolean[] visited, int s, ArrayList<ArrayList<Integer>> adj, int parent) {
        visited[s] = true;
        ArrayList<Integer> neighbours = adj.get(s);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                if (dfs(visited, neighbour, adj, s)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i, -1));
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    visited[cur.node] = true;
                    ArrayList<Integer> neighbours = adj.get(cur.node);
                    for (int neighbour : neighbours) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            queue.add(new Pair(neighbour, cur.node));
                        } else if (neighbour != cur.parent) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
//        ArrayList<Integer> child1 = new ArrayList<>();
//        child1.add(1);
//        input.add(child1);
//
//        ArrayList<Integer> child2 = new ArrayList<>();
//        child2.add(0);
//        child2.add(2);
//        child2.add(4);
//        input.add(child2);
//
//        ArrayList<Integer> child3 = new ArrayList<>();
//        child3.add(1);
//        child3.add(3);
//        input.add(child3);
//
//        ArrayList<Integer> child4 = new ArrayList<>();
//        child4.add(2);
//        child4.add(4);
//        input.add(child4);
//
//        ArrayList<Integer> child5 = new ArrayList<>();
//        child5.add(1);
//        child5.add(3);
//        input.add(child5);

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        ArrayList<Integer> child1 = new ArrayList<>();
        child1.add(2);
        input.add(child1);

        ArrayList<Integer> child2 = new ArrayList<>();
        child2.add(1);
        child2.add(3);
        input.add(child2);

        ArrayList<Integer> child3 = new ArrayList<>();
        child3.add(2);

        input.add(child3);


        System.out.println(isCycle(4, input));

    }
}
