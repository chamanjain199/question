package geeksForGeeks.graph;

import javax.accessibility.AccessibleHyperlink;
import java.util.LinkedList;
import java.util.Queue;


public class IsGraphBipartite {
    public static boolean isBipartiteDFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        for (int i = 0; i < len; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, colors, graph, 0)) return false;
            }
        }
        return true;
    }

    public static boolean dfs(int source, int[] colors, int[][] graph, int lastColor) {
        int sourceColor = lastColor == 1 ? 2 : 1;
        colors[source] = sourceColor;
        int[] children = graph[source];
        for (int child : children) {
            if (colors[child] == 0) {
                if (!dfs(child, colors, graph, sourceColor)) return false;
            } else if (colors[child] == sourceColor) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartiteBFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        for (int i = 0; i < len; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    int[] children = graph[cur];
                    int childColor = colors[cur] == 1 ? 2 : 1;
                    for (int child : children) {
                        if (colors[child] == 0) {
                            queue.add(child);
                            colors[child] = childColor;
                        } else if (colors[child] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isBipartiteDFS(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}
