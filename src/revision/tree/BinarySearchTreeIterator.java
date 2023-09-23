package revision.tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        addAllNodeTillLastLeftNode(root);
    }

    private void addAllNodeTillLastLeftNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        addAllNodeTillLastLeftNode(node.right);
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
