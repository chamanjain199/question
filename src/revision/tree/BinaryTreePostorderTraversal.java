package revision.tree;

import java.util.ArrayList;
import java.util.List;

//left, right,root
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderIterative(root, ans);
        return ans;
    }

    public void postOrderIterative(TreeNode node, List<Integer> ans) {
        if (node != null) {
            postOrderIterative(node.left, ans);
            postOrderIterative(node.right, ans);
            ans.add(node.val);
        }
    }
}
