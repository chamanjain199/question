package revision.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartiteBFS(int[][] graph) {
        int len = graph.length;
        int[] colored = new int[len];
        Queue<Integer> queue;
        for (int i = 0; i < len; i++) {
            if (colored[i] == 0) {
                queue = new LinkedList<>();
                queue.add(i);
                colored[i] = 1;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int childColor = colored[node] == 1 ? 2 : 1;
                    for (int e : graph[node]) {
                        if (colored[e] == 0) {
                            queue.add(e);
                            colored[e] = childColor;
                        } else if (colored[e] == colored[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int len = graph.length;
        int[] colored = new int[len];
        for (int i = 0; i < len; i++) {
            if (colored[i] == 0) {
                if (!isBipartiteDFSRec(i, 1, graph, colored)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFSRec(int node, int parentColor, int[][] graph, int[] colored) {
        colored[node] = parentColor;
        int childColor = parentColor == 1 ? 2 : 1;
        for (int e : graph[node]) {
            if (colored[e] == 0) {
                colored[e] = childColor;
                if (!isBipartiteDFSRec(e, childColor, graph, colored)) {
                    return false;
                }
            } else if (colored[e] == parentColor) {
                return false;
            }
        }
        return true;
    }
}
