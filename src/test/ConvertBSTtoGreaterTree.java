package test;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Hold {
    int total;
}

public class ConvertBSTtoGreaterTree {
    public static TreeNode convertBSTD(TreeNode root) {
        Integer i = 25;  //25 is the sum of all node in tree , so after subtracting each node val from i it should be 0
        Hold h = new Hold();
        h.total = 25;
        reverseInOrderTraversalD(root, h);
        reverseInOrderTraversalInt(root,i);

        System.out.println(" after  " + h.total);
        System.out.println(" after  " + i);
        return root;
    }

    public static void reverseInOrderTraversalD(TreeNode root, Hold hold) {
        if (root == null) {
            return;
        }
        reverseInOrderTraversalD(root.right, hold);
        hold.total = hold.total - root.val;
        reverseInOrderTraversalD(root.left, hold);
    }
    public static void reverseInOrderTraversalInt(TreeNode root, Integer total) {
        if (root == null) {
            return;
        }
        reverseInOrderTraversalInt(root.right, total);
        total = total - root.val;
        reverseInOrderTraversalInt(root.left, total);
    }
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode currentNode = treeNodes.remove();
            System.out.println(currentNode.val);
            if (currentNode.left != null) {
                treeNodes.add(currentNode.left);
            }
            if (currentNode.right != null) {
                treeNodes.add(currentNode.right);
            }
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        levelOrder(convertBSTD(root));

    }
}
