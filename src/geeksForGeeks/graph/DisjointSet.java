package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            ranks.add(0);
            sizes.add(1);
            parent.add(i);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return uParent;
    }

    public void unionByRank(int u, int v) {

        int uParent = findUParent(u);
        int vParent = findUParent(v);

        if (uParent == vParent) {
            return;
        }
        int uParentRank = ranks.get(uParent);
        int vParentRank = ranks.get(vParent);
        if (uParentRank == vParentRank) {
            parent.set(vParent, uParent);
            ranks.set(uParent, uParentRank + 1);
        } else if (uParentRank < vParentRank) {
            parent.set(uParent, vParent);
        } else {
            parent.set(vParent, uParent);
        }

    }

    List<Integer> sizes = new ArrayList<>();

    public void unionBySize(int u, int v) {
        int uParent = findUParent(u);
        int vParent = findUParent(v);
        if (uParent == vParent) {
            return;
        }
        int uParentSize = sizes.get(uParent);
        int vParentSize = sizes.get(vParent);
        if (uParentSize < vParentSize) {
            parent.set(uParent, vParent);
            sizes.set(vParent, uParentSize + vParentSize);
        } else {
            parent.set(vParent, uParent);
            sizes.set(uParent, uParentSize + vParentSize);
        }

    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(9);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        System.out.println(ds.findUParent(3));
        System.out.println(ds.findUParent(7));
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("In Same Set");
        } else {
            System.out.println("Not same set");
        }
        ds.unionByRank(3, 7);
        System.out.println(ds.findUParent(3));
        System.out.println(ds.findUParent(7));
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("In Same Set");
        } else {
            System.out.println("Not same set");
        }


    }
}
