package geeksForGeeks.graph;

import java.util.*;

public class kruskalsAlgorithm {
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUParent(int node) {
            int nodeParent = parent.get(node);
            if (nodeParent == node) {
                return nodeParent;
            }
            int uParent = findUParent(nodeParent);
            parent.set(node, uParent);
            return uParent;
        }

        public boolean unionByRank(int u, int v) {
            int u_parent_u = findUParent(u);
            int u_parent_v = findUParent(v);
            if (u_parent_u == u_parent_v) {
                return true;
            }
            int u_rank = rank.get(u_parent_u);
            int v_rank = rank.get(u_parent_v);

            if (u_rank < v_rank) {
                parent.set(u_parent_u, u_parent_v);
            } else if (v_rank < u_rank) {
                parent.set(u_parent_v, u_parent_u);
            } else {
                parent.set(u_parent_v, u_parent_u);
                rank.set(u_parent_u, u_rank + 1);
            }
            return false;
        }
    }

    class Edge implements Comparable<Edge> {
        int u;
        int v;
        int wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ArrayList<ArrayList<Integer>> children = adj.get(i);
            for (ArrayList<Integer> child : children) {
                edges.add(new Edge(i, child.get(0), child.get(1)));
            }
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edges);
        int mstW = 0;
        for (Edge edge : edges) {

            if (ds.findUParent(edge.u) != ds.findUParent(edge.v)) {
                mstW += edge.wt;
                ds.unionByRank(edge.u, edge.v);
            }
        }
        return mstW;

    }

    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        DisjointSet ds = new DisjointSet(v);
        Collections.sort(edges);
        int mstW = 0;
        for (Edge edge : edges) {
            if (ds.findUParent(edge.u) != ds.findUParent(edge.v)) {
                mstW += edge.wt;
                ds.unionByRank(edge.u, edge.v);
            }
        }
        return mstW;
    }

    public static void main(String[] args) {

    }
}
