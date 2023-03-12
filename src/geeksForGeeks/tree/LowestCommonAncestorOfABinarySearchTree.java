package geeksForGeeks.tree;

public class LowestCommonAncestorOfABinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = p.val < q.val ? p : q;
        TreeNode right = left == p ? q : p;
        return lowestCommonAncestorRec(root, left, right);
    }

    public static TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (p.val > root.val) {
                return lowestCommonAncestorRec(root.right, p, q);
            }
            if (q.val < root.val) {
                return lowestCommonAncestorRec(root.left, p, q);
            }
            return root;
        }
        return null;
    }

    public static TreeNode lowestCommonAncestorRecAnother(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            int cur = root.val;
            if (cur < p.val && cur < q.val) {
                return lowestCommonAncestorRec(root.right, p, q);
            }
            if (cur > p.val && cur > q.val) {
                return lowestCommonAncestorRec(root.left, p, q);
            }
            return root;
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        lowestCommonAncestor(root, root, root.left);

    }
}
