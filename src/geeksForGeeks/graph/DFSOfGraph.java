package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSOfGraph {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean visited[];

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        dfsOfGraphRec(adj, 0);
        return ans;
    }

    public void dfsOfGraphRec(ArrayList<ArrayList<Integer>> adj, int curNode) {
        visited[curNode] = true;
        ans.add(curNode);
        ArrayList<Integer> allChild = adj.get(curNode);
        for (Integer child :
                allChild) {
            if (!visited[child]) {
                visited[child] = true;
                dfsOfGraphRec(adj, child);
            }
        }
    }


}
