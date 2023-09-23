package revision.tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedRec(root) >= 0;
    }

    public int isBalancedRec(TreeNode root) {
        if (root != null) {
            int left = isBalancedRec(root.left);
            if (left == -1) {
                return -1;
            }
            int right = isBalancedRec(root.right);
            if (right == -1) {
                return -1;
            }
            int diff = Math.abs(left - right);
            if (diff > 1) {
                return -1;
            }
            return 1 + Math.max(left, right);
        }
        return 0;
    }
}
