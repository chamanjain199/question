package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOfGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> explored = new ArrayList<>();
        boolean visit[] = new boolean[V];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visit[cur]=true;
            ArrayList<Integer> allChildren = adj.get(cur);
            for (Integer child : allChildren) {
                if(!visit[child]){
                    visit[child]=true;
                    queue.add(child);
                }
            }
            explored.add(cur);

        }
        return explored;
    }

    public static void main(String[] args) {

    }
}
