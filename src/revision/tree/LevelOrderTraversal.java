package revision.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            ans.add(node1.data);
            if (node1.left != null) {
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }
        }
        return ans;
    }
}
