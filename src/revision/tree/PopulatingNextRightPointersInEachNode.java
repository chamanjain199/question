package revision.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int side = queue.size();
            Node prevRight = null;
            for (int i = 0; i < side; i++) {
                Node poll = queue.poll();
                if (prevRight != null) {
                    if (poll.left != null) {
                        prevRight.next = poll.left;
                    } else if (poll.right != null) {
                        prevRight.next = poll.right;
                    }
                }
                if (poll.left != null && poll.right != null) {
                    poll.left.next = poll.right;
                }
                prevRight = poll.left;
                if (poll.right != null) {
                    prevRight = poll.right;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
