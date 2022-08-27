package self.graph;


import java.util.*;


public class PrintAllPath {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<GraphNode> nodeList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodeList.add(new GraphNode(i));
        }

        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                addDirectedEdge(i, graph[i][j], nodeList);
            }
        }
        dfsRec(nodeList, 0, graph.length - 1, new ArrayList<>());
        return results;
    }

    private void addDirectedEdge(int i, int j, List<GraphNode> nodeList) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }

    private void dfsRec(List<GraphNode> nodeList, int source, int destination, List<Integer> list) {
        if (source == destination) {
            list.add(destination);
            results.add(new ArrayList<>(list));
            return;
        }
        GraphNode currentNode = nodeList.get(source);
        list.add(currentNode.index);
        for (GraphNode node :
                currentNode.neighbours) {
            dfsRec(nodeList, node.index, destination, list);
            list.remove(list.size() - 1);
        }
    }



    public static void main(String[] args) {
        PrintAllPath obj = new PrintAllPath();
        System.out.println(obj.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph == null || graph.length == 0)
            return paths;
        int src = 0;
        int dest = graph.length - 1;

        List<Integer> path = new ArrayList<>();
        dfs2(graph, src, dest, path, paths);

        return paths;
    }

    public void dfs2(int[][] graph, int v, int dest, List<Integer> path, List<List<Integer>> paths) {
        path.add(v);
        if(v == dest) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] neighs = graph[v];
        for(int neigh : neighs) {
            dfs2(graph, neigh, dest, path, paths);
            path.remove(path.size()-1);
        }
    }
}
