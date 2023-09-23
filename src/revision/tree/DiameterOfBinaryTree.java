package revision.tree;

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeRec(root);
        return max;
    }

    public int diameterOfBinaryTreeRec(TreeNode root) {
        if (root != null) {
            int left = diameterOfBinaryTreeRec(root.left);
            int right = diameterOfBinaryTreeRec(root.right);
            max = Math.max(max, left + right);
            return 1 + Math.max(left, right);
        }
        return 0;
    }
}
