package revision.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> subList;
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node;
            subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (flag) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
            }
            ans.add(subList);
            flag = !flag;
        }
        return ans;
    }
}
