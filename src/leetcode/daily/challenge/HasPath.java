package leetcode.daily.challenge;

import java.util.*;

public class HasPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<GraphNode> nodeList = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            nodeList.add(new GraphNode(i));
        }

        for (int i = 0; i < edges.length; i++) {
            addUndirectedEdge(edges[i][0], edges[i][1], nodeList);
        }
        return hasPath(nodeList,source,destination);
//        while (!queue.isEmpty()) {
//            GraphNode currentNode = queue.remove();
//            currentNode.visited = true;
//            if (currentNode.index == destination) {
//                return true;
//            }
//            for (GraphNode node :
//                    currentNode.neighbours) {
//                if (!node.visited)
//                    queue.add(node);
//            }
//
//        }

        //return false;
    }

    private boolean hasPath(List<GraphNode> graphNodes, int source, int destination) {
        if (source == destination ) {
            return true;
        }
        GraphNode currentNode = graphNodes.get(source);
        currentNode.visited = true;
        for (GraphNode node :
                currentNode.neighbours) {
            if (!node.visited) {
                boolean hasPath = hasPath(graphNodes, node.index, destination);
                if (hasPath) {
                    return true;
                }

            }
        }
        return false;
    }

    private void addUndirectedEdge(int i, int j, List<GraphNode> nodeList) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);

    }

    public static void main(String[] args) {
        HasPath obj = new HasPath();
        System.out.println(obj.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

    public boolean validPathfast(int n, int[][] edges, int start, int end) {
        boolean[] used = new boolean[n];
        used[start] = true;
        boolean newUsedFound = true;
        while (!used[end] && newUsedFound) {
            newUsedFound = false;
            for (int i = edges.length - 1; i >= 0; i--) {
                if (used[edges[i][0]]) {
                    if (!used[edges[i][1]])
                        newUsedFound = used[edges[i][1]] = true;
                } else if (used[edges[i][1]]) {
                    newUsedFound = used[edges[i][0]] = true;
                }
            }
        }
        return used[end];
    }
}
