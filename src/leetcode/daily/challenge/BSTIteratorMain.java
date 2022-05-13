package leetcode.daily.challenge;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        addAllRecusiveCallForFirstRootNodeToLeft(root);
    }

    private void addAllRecusiveCallForFirstRootNodeToLeft(TreeNode root) {
        stack.push(root);
        addAllRecusiveCallForFirstRootNodeToLeft(root.left);
    }

    public int next() {
        TreeNode tn = stack.pop();
        addAllRecusiveCallForFirstRootNodeToLeft(tn.right);
        return tn.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BSTIteratorMain {
}
