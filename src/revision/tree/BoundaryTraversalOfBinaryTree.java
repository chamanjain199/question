package revision.tree;

import java.util.*;

public class BoundaryTraversalOfBinaryTree {

    static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }


    static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.data);
        Node copy = node.left;
        while (copy != null) {
            if (!isLeaf(copy)) {
                ans.add(copy.data);
            }
            if (copy.left != null) {
                copy = copy.left;
            } else {
                copy = copy.right;
            }
        }
        copy = node;
        addLeafNode(copy, ans);
        copy = node.right;
        int size = ans.size();
        while (copy != null) {
            if (!isLeaf(copy)) {
                ans.add(size , copy.data);
            }
            if (copy.right != null) {
                copy = copy.right;
            } else if (copy.left != null) {
                copy = copy.left;
            } else {
                copy = null;
            }
        }
        return ans;
    }

    public static void addLeafNode(Node node, List<Integer> ans) {
        if (node != null) {
            if (isLeaf(node)) {
                ans.add(node.data);
            }
            addLeafNode(node.left, ans);
            addLeafNode(node.right, ans);
        }
    }


    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = boundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }

    }
}