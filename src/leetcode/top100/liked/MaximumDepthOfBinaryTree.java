package leetcode.top100.liked;

public class MaximumDepthOfBinaryTree {

    int maxDepth = 0;

    private void getMaxDepth(TreeNode rooNode,int depth) {
        if (rooNode == null) {
            return;
        }
        depth++;
        getMaxDepth(rooNode.left, depth);
        getMaxDepth(rooNode.right, depth);
        maxDepth = Math.max(maxDepth, depth);
    }

    public int maxDepth(TreeNode root) {
        getMaxDepth(root,0);
        return maxDepth;
    }

    public static int maxDepth1(TreeNode root) {
        return root==null?0:1+Math.max(maxDepth1(root.left),maxDepth1(root.right));
    }
    public static void main(String[] args) {



    }
}
