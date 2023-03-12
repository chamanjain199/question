package geeksForGeeks.tree;

class MaxSumBinaryTreeInfo {
    int sum;
    int min;
    int max;

    public MaxSumBinaryTreeInfo(int sum, int min, int max) {
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}

public class MaximumSumBSTInBinaryTree {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        findMaxSumBST(root);
        return maxSum;
    }

    public MaxSumBinaryTreeInfo findMaxSumBST(TreeNode root) {
        if (root == null) return new MaxSumBinaryTreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        MaxSumBinaryTreeInfo left = findMaxSumBST(root.left);
        MaxSumBinaryTreeInfo right = findMaxSumBST(root.right);
        if (left != null && right != null && left.max < root.val && right.min > root.val) {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            return new MaxSumBinaryTreeInfo(sum, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
