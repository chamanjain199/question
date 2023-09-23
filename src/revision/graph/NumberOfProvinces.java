package revision.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet disjointSet = new DisjointSet(V);
        for (int i = 0; i < adj.size(); i++) {
            int up = disjointSet.findUParent(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) == 1) {
                    int vp = disjointSet.findUParent(j);
                    if (up != vp) {
                        disjointSet.unionByRank(i, j);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < V; i++) {
            if (disjointSet.parent.get(i) == i) {
                ans++;
            }
        }
        return ans;
    }

}
