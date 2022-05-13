package leetcode.daily.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class IncreasingBST {
    static TreeNode newNode = new TreeNode();
    static TreeNode newNodeHead = newNode;

    public static TreeNode increasingBST(TreeNode root) {

        inOrderTraversal(root);
        return newNodeHead.right;

    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);

        newNode.right = new TreeNode(root.val);
        newNode = newNode.right;
        inOrderTraversal(root.right);


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
        //[2, 0, 3, -4, 1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
//
//        root.left.left = new TreeNode(-4);
//        root.left.right = new TreeNode(1);
//        root.left.right.right = new TreeNode(3);
//
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//        root.right.right.right = new TreeNode(8);

        levelOrder(increasingBST(root));

    }
}
