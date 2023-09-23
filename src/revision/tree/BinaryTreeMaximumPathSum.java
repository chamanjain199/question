package revision.tree;

public class BinaryTreeMaximumPathSum {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumRec(root);
        return maxPath;
    }

    public int maxPathSumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxPathSumRec(root.left));// negative ko leke or negative karne ki jarirt nahi hai ,
        int rightSum = Math.max(0, maxPathSumRec(root.right));
        maxPath = Math.max(maxPath, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
    }
}
