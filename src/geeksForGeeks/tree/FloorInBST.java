package geeksForGeeks.tree;

public class FloorInBST {
    public static int floorInBST(TreeNode root, int X) {

        if (root == null) return 0;
        int ans = root.val;
        while (root != null) {
            if (root.val < X) {
                ans = root.val;
                root = root.right;
            } else if (root.val == X) {
                ans = root.val;
                break;
            } else {
                root = root.left;
            }
        }
        return ans;

    }

    public static int ceilInBST(TreeNode root, int X) {

        if (root == null) return 0;
        int ans = -1;
        while (root != null) {
            if (root.val > X) {
                ans = root.val;
                root = root.left;
            } else if (root.val == X) {
                ans = root.val;
                break;
            } else {
                root = root.right;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
