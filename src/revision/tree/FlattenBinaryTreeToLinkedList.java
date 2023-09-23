package revision.tree;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode leftRightMost = cur.left;
                while (leftRightMost.right != null) {
                    leftRightMost = leftRightMost.right;
                }
                leftRightMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
