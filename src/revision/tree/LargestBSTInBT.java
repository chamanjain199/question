package revision.tree;

import java.util.Map;

class NodeValue {
    public int maxNode, minNode, maxSize;

    public NodeValue(int maxNode, int minNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

public class LargestBSTInBT {
    static int largestBst(Node root) {

        return largestBstInBT(root).maxSize;
    }

    static NodeValue largestBstInBT(Node root) {
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        NodeValue left = largestBstInBT(root.left);
        NodeValue right = largestBstInBT(root.right);
        if (left.maxNode < root.data && right.minNode > root.data) {
            return new NodeValue(Math.max(root.data, right.maxNode), Math.min(root.data, left.minNode), left.maxSize + right.maxSize + 1);
        }
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));

    }
}
