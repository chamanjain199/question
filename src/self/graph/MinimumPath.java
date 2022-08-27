package self.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumPath {
    public void allPathsSourceTarget(int[][] graph) {
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
       // return results;
    }

    private void addDirectedEdge(int i, int j, List<GraphNode> nodeList) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }

    private void dfsRec(List<GraphNode> nodeList, int source, int destination, List<Integer> list) {
        if (source == destination) {
            list.add(destination);
          //  results.add(new ArrayList<>(list));
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

    }
}
