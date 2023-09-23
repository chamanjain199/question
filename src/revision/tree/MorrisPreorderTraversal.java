package revision.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                elements.add(root.val);
                root = root.right;
            } else {
                TreeNode leftRightMost = root.left;
                while (leftRightMost.right != null && leftRightMost.right != root) {
                    leftRightMost = leftRightMost.right;
                }
                if (leftRightMost.right == null) {
                    leftRightMost.right = root;
                    elements.add(root.val);
                    root = root.left;
                } else {
                    leftRightMost.right = null;
                    root = root.right;
                }
            }
        }
        return elements;
    }
}
