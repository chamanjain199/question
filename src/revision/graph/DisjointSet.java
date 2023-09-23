package revision.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
       int nodeParent= parent.get(node);
        if (node == nodeParent) {
            return node;
        }
        int up = findUParent(nodeParent);
        parent.set(node, up);
        return up;
    }

    public void unionByRank(int n1, int n2) {
        int upn1 = findUParent(n1);
        int upn2 = findUParent(n2);
        if (upn1 == upn2) return;
        int rankOfup1 = rank.get(upn1);
        int rankOfup2 = rank.get(upn2);
        if (rankOfup1 < rankOfup2) {
            parent.set(upn1, upn2);
        } else if (rankOfup2 < rankOfup1) {
            parent.set(upn2, upn1);
        } else {
            parent.set(upn2, upn1);
            rank.set(upn1, rank.get(upn1) + 1);
        }
    }

    public void unionBySize(int n1, int n2) {
        int upn1 = findUParent(n1);
        int upn2 = findUParent(n2);
        if (upn1 == upn2) return;
        int sizeOfup1 = rank.get(upn1);
        int sizeOfup2 = rank.get(upn2);
        if (sizeOfup1 < sizeOfup2) {
            parent.set(upn1, upn2);
            size.set(upn1, size.get(upn1) + size.get(upn2));
        } else {
            parent.set(upn2, upn1);
            size.set(upn2, size.get(upn1) + size.get(upn2));
        }
    }
}
