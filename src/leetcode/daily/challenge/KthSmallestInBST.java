package leetcode.daily.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestInBST {

    int count = 0;
    int k = 0;
    int found = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        try {
            inOrderTraversal(root);
        }catch (RuntimeException e){

        }
        return found;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        count++;
        if (count == k) {
            found = root.val;
            throw new RuntimeException("Found");
        }


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
        KthSmallestInBST obj=new KthSmallestInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(obj.kthSmallest(root,3));

    }
}
