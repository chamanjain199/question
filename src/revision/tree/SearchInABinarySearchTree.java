package revision.tree;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            int rootVal = root.val;
            if (val == rootVal) {
                return root;
            } else if (val > rootVal) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
        return null;

    }

}
