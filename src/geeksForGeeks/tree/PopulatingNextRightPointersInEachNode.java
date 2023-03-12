package geeksForGeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int sizeOfCurLevel = queue.size();

            Node prev = null;
            for (int i = 0; i < sizeOfCurLevel; i++) {
                Node cur = queue.poll();

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;

            }
        }
        return root;

    }

    public Node connect2(Node root) {

        if (root == null) return null;
        Node pre = root;
        while (pre.left != null) {
            Node cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;

    }

    public static void main(String[] args) {

    }
}
