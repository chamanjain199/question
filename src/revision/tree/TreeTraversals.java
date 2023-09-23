package revision.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NodeWithIndex {
    Node node;

    int index;

    public NodeWithIndex(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class TreeTraversals {
    public static List<List<Integer>> getTreeTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<NodeWithIndex> stack = new Stack<>();
        stack.push(new NodeWithIndex(root, 1));
        while (!stack.isEmpty()) {
            NodeWithIndex nodeWithIndex = stack.pop();
            if (nodeWithIndex.index == 1) {
                preOrder.add(nodeWithIndex.node.data);
                nodeWithIndex.index++;
                stack.push(nodeWithIndex);
                if (nodeWithIndex.node.left != null) {
                    stack.push(new NodeWithIndex(nodeWithIndex.node.left, 1));
                }
            } else if (nodeWithIndex.index == 2) {
                inOrder.add(nodeWithIndex.node.data);
                nodeWithIndex.index++;
                stack.push(nodeWithIndex);
                if (nodeWithIndex.node.right != null) {
                    stack.push(new NodeWithIndex(nodeWithIndex.node.right, 1));
                }
            } else {
                postOrder.add(nodeWithIndex.node.data);
            }
        }

        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getTreeTraversal(null));
    }
}
