package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> sortAccordingToTimeline = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(sortAccordingToTimeline, adj, visited, i);
        }
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                reverseGraph.get(child).add(i);
            }
        }
        visited = new boolean[V];
        int count = 0;
        while (!sortAccordingToTimeline.isEmpty()) {
            int i = sortAccordingToTimeline.pop();
            if (!visited[i]) {
                count++;
                dfs2(reverseGraph, visited, i);
            }
        }

        return count;
    }

    public static void dfs(Stack<Integer> sortAccordingToTimeline, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[parent] = true;
        List<Integer> children = adj.get(parent);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(sortAccordingToTimeline, adj, visited, child);
            }
        }
        sortAccordingToTimeline.add(parent);
    }

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[parent] = true;
        List<Integer> children = adj.get(parent);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs2(adj, visited, child);
            }
        }
    }

    public static void main(String[] args) {
        KosarajuAlgorithm algorithm = new KosarajuAlgorithm();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(1);


        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(3);

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(4);

        arrayLists.add(list1);
        arrayLists.add(list2);
        arrayLists.add(list3);
        arrayLists.add(list4);
        arrayLists.add(list5);

        algorithm.kosaraju(5, arrayLists);
    }
}
