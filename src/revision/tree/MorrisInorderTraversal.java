package revision.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode leftRightMost = root.left;
                while (leftRightMost.right != null && leftRightMost.right != root) {
                    leftRightMost = leftRightMost.right;
                }
                if (leftRightMost.right == null) {
                    leftRightMost.right = root;
                    root = root.left;
                } else {
                    leftRightMost.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
