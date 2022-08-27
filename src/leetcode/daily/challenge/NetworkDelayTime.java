package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {


    public static int networkDelayTime(int[][] times, int n, int k) {

        List<GraphNode> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new GraphNode(i));
        }
        for (int i = 0; i < n; i++) {
            addDirectedEdge(times[i][0], times[i][0], times[i][0], nodeList);
        }

        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>();
        GraphNode kthNode = nodeList.get(k);
        kthNode.distance = 0;
        priorityQueue.add(nodeList.get(k));


        while (!priorityQueue.isEmpty()) {

            GraphNode currentNode = priorityQueue.remove();

//            for (GraphNode neighbours :
//                    currentNode.neighbours.keySet()) {
//
//                if (neighbours.distance > currentNode.distance + currentNode.neighbours.get(neighbours)) {
//                    neighbours.distance = currentNode.distance + currentNode.neighbours.get(neighbours);
//                    priorityQueue.add(neighbours);
//                }
//
//            }

        }

        return 0;
    }

    private static void addDirectedEdge(int i, int j, int w, List<GraphNode> nodeList) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
       // first.neighbours.put(second, w);
    }


    public static void main(String[] args) {

    }
}
