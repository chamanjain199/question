package geeksForGeeks.tree;

import javax.management.Query;
import java.util.*;

public class ViewsOfBinaryTree {
    ArrayList<Integer> ans = new ArrayList<>();

    ArrayList<Integer> leftView(Node root) {
        preorderTraversalRecursion(root, 0);
        return ans;
    }

    private void preorderTraversalRecursion(Node node, int level) {
        if (node != null) {
            if (level == ans.size()) ans.add(node.data);
            preorderTraversalRecursion(node.left, level + 1);
            preorderTraversalRecursion(node.right, level + 1);
        }
    }

    ArrayList<Integer> rightView(Node root) {
        preorderTraversalRecursion(root, 0);
        return ans;
    }

    private void reversePreorderTraversalRecursion(Node node, int level) {
        if (node != null) {
            if (level == ans.size()) ans.add(node.data);
            preorderTraversalRecursion(node.left, level + 1);
            preorderTraversalRecursion(node.right, level + 1);
        }
    }

    ArrayList<Integer> topView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(new Pair(root, 0));
        Pair current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            map.putIfAbsent(current.key, current.val);
            if (current.val.left != null) {
                queue.add(new Pair(current.val.left, current.key - 1));
            }
            if (current.val.right != null) {
                queue.add(new Pair(current.val.right, current.key + 1));
            }
        }
        map.forEach((key, value) -> ans.add(value.data));
        return ans;
    }

    ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(new Pair(root, 0));
        Pair current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            map.put(current.key, current.val);
            if (current.val.left != null) {
                queue.add(new Pair(current.val.left, current.key - 1));
            }
            if (current.val.right != null) {
                queue.add(new Pair(current.val.right, current.key + 1));
            }
        }
        map.forEach((key, value) -> ans.add(value.data));
        return ans;
    }

    ArrayList<Integer> morrisInorder(Node root) {
        Node cur = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.data);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    ans.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ViewsOfBinaryTree viewsOfBinaryTree = new ViewsOfBinaryTree();
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        System.out.println(viewsOfBinaryTree.topView(root));
    }
}
