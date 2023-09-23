package revision.graph;


import java.util.ArrayList;

public class CloneGraph {
    Node[] dp = new Node[101];

    public Node cloneGraph(Node node) {
        return cloneGraphRec(node);
    }

    private Node cloneGraphRec(Node node) {

        if (dp[node.val] != null) {
            return dp[node.val];
        }
        Node newNode = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        dp[node.val] = newNode;
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraphRec(n));
        }
        return newNode;
    }
}
