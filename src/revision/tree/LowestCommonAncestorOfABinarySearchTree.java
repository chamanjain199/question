package revision.tree;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            int val = root.val;
            if (val < p.val && val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (val > p.val && val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }
        return null;
    }
}
