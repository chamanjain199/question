package revision.tree;

import java.util.ArrayList;
import java.util.List;

//Root left right
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        preOrder(root, elements);
        return elements;
    }

    private void preOrder(TreeNode root, List<Integer> elements) {
        if (root != null) {
            elements.add(root.val);
            preOrder(root.left, elements);
            preOrder(root.right, elements);
        }
    }
}
