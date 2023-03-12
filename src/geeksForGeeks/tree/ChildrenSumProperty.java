package geeksForGeeks.tree;

public class ChildrenSumProperty {
    private static int getChildSum(TreeNode root) {
        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.val;
        }
        if (root.right != null) {
            childSum += root.right.val;
        }
        return childSum;
    }

    private static void setChildVal(TreeNode root, int val) {
        if (root.left != null) {
            root.left.val = val;
        }
        if (root.right != null) {
            root.right.val = val;
        }
    }

    public static void changeTree(TreeNode root) {
        if (root != null) {
            int childSum = getChildSum(root);
            if (childSum < root.val) {
                setChildVal(root, root.val);
            }
            changeTree(root.left);
            changeTree(root.right);
            if (root.left != null || root.right != null) { // Do not update leaf node
                root.val = childSum;
            }
        }
    }

    public static void main(String[] args) {

    }
}
