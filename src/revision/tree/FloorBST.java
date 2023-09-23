package revision.tree;

public class FloorBST {

    public static int floorInBST(TreeNode root, int X) {
        if (root == null) return 0;
        int ans = 0;
        while (root != null) {
            if (root.val < X && root.val > ans) {
                ans = root.val;
                root = root.right;
            } else if (root.val == X) {
                return X;
            } else {
                root = root.left;
            }
        }
        return ans;

    }

    public static int findCeil(TreeNode root, int x) {
        if (root == null) return 0;
        int ans = -1;
        while (root != null) {
            if (root.val > x) {
                if (ans == -1 || root.val < ans) {
                    ans = root.val;
                }
                root = root.left;
            } else if (root.val == x) {
                return x;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
