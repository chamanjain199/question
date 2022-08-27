package self.graph;/*
// Definition for a Node.

*/

import java.util.*;

class CloneGraph {
    Node [] map = new Node[101];
    public Node cloneGraph(Node node) {
        return cloneGraphRec(node);
    }
    private Node cloneGraphRec(Node oldNode) {

        if(map[oldNode.val]!=null){
            return map[oldNode.val];
        }
        Node newNode = new Node(oldNode.val,new ArrayList<>(oldNode.neighbors.size()));
        map[oldNode.val]=newNode;

        for (Node node :
                oldNode.neighbors) {
            newNode.neighbors.add(cloneGraphRec(node));
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node graphNode1 = new Node(1);
        Node graphNode2 = new Node(2);
        Node graphNode3 = new Node(3);
        Node graphNode4 = new Node(4);
        graphNode1.neighbors = Arrays.asList(graphNode2, graphNode4);
        graphNode2.neighbors = Arrays.asList(graphNode1, graphNode3);
        graphNode3.neighbors = Arrays.asList(graphNode2, graphNode4);
        graphNode4.neighbors = Arrays.asList(graphNode1, graphNode3);
        new CloneGraph().cloneGraph(graphNode1);


    }

}