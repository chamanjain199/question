package geeksForGeeks.tree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return depth(root) >= 0;
    }

    public int depth(TreeNode node) {
        if (node != null ) {
            int ld = depth(node.left);
            if (ld == -1)
                return -1;
            int rd = depth(node.right);
            if (rd == -1)
                return -1;

            int diff = Math.abs(ld - rd);
            if (diff > 1) {
                return -1;
            }
            return 1 + Math.max(ld, rd);
        }
        return 0;
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(balancedBinaryTree.isBalanced(root));
    }
}
