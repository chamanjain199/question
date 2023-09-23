package revision.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int fistNodeIndex = queue.peek().index;
            int lastNodeIndex = 0;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;
                if (i == size - 1) {
                    lastNodeIndex = index;
                }
                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * (index - fistNodeIndex) + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * (index - fistNodeIndex) + 2));
                }
            }
            max = Math.max(max, lastNodeIndex - fistNodeIndex + 1);
        }
        return max;
    }
}
