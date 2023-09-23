package revision.tree;

public class KthSmallestElementInABST {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int l = kthSmallest(root.left, k);
        if (l > 0) {
            return l;
        }
        count = count + 1;
        if (count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }

}
