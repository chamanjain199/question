package geeksForGeeks.tree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBSTRec(TreeNode root, long upperBound, long lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }
        return isValidBSTRec(root.left, root.val, lowerBound) && isValidBSTRec(root.right, upperBound, root.val);
    }

    public static void main(String[] args) {

    }
}
