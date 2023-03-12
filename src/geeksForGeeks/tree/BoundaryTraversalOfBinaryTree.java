package geeksForGeeks.tree;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversalOfBinaryTree {
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (!isLeaf(node)) {
            ans.add(node.data);
        }
        leftBoundary(node.left, ans);
        bottomBoundary(node, ans);
        rightBoundary(node.right, stack);
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }


    void leftBoundary(Node node, ArrayList<Integer> list) {
        if (node != null) {
            if (!isLeaf(node))
                list.add(node.data);

            if (node.left != null) {
                leftBoundary(node.left, list);
            } else if (node.right != null) {
                leftBoundary(node.right, list);
            }
        }
    }

    void bottomBoundary(Node node, ArrayList<Integer> list) {
        if (node != null) {
            if (isLeaf(node)) {
                list.add(node.data);
            }
            if (node.left != null)
                bottomBoundary(node.left, list);
            if (node.right != null)
                bottomBoundary(node.right, list);
        }
    }

    void rightBoundary(Node node, Stack<Integer> stack) {
        if (node != null) {
            if (node.left != null || node.right != null)
                stack.add(node.data);
            if (node.right != null) {
                rightBoundary(node.right, stack);
            } else if (node.left != null) {
                rightBoundary(node.left, stack);
            }
        }
    }


    public static void main(String[] args) {
        BoundaryTraversalOfBinaryTree boundaryTraversalOfBinaryTree = new BoundaryTraversalOfBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(boundaryTraversalOfBinaryTree.boundary(root));


    }
}
