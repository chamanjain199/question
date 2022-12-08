package geeksForGeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    static boolean isNullFound = false;

    static boolean isCompleteBT(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode == null) {
                if (!isNullFound)
                    isNullFound = true;
            } else if (isNullFound) {
                return false;
            } else {
                if (curNode.left == null && curNode.right != null) {
                    return false;
                }
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //37 12 12 76 71 29 72 63 N 24 21

        Node root = new Node(3);
        root.left = new Node(4);
//        root.right = new Node(12);
//
//        root.left.left = new Node(76);
//        root.left.right = new Node(71);
//
//        root.right.left = new Node(29);
//        root.right.right = new Node(72);
//
       // root.left.left.left = new Node(63);
        // root.left.left.right = new Node(4);


        System.out.println(isCompleteBT(root));

    }
}

