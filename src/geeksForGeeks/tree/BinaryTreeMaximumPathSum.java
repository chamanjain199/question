package geeksForGeeks.tree;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return maxSum;

    }

    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxPathSum2(root.left));
        int rightSum = Math.max(0, maxPathSum2(root.right));
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);

    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }
}
