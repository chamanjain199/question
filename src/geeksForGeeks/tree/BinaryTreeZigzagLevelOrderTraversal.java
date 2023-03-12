package geeksForGeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            int sizeOfCurLevel = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < sizeOfCurLevel; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (flag) {
                    levelList.add(cur.val);
                } else {
                    levelList.add(0, cur.val);
                }

            }
            flag = !flag;
            ans.add(levelList);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
