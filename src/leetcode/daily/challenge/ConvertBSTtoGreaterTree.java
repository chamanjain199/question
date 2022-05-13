package leetcode.daily.challenge;

import java.util.*;

class Hold{
    int total;
}

public class ConvertBSTtoGreaterTree {

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        reverseInOrderTraversal(root);
        System.out.println(sum);
        return root;
    }

    public static void reverseInOrderTraversal(TreeNode root) {
        if (root != null) {
            reverseInOrderTraversal(root.right);
            sum += root.val;
            root.val = sum;
            reverseInOrderTraversal(root.left);
        }
    }

    public static TreeNode convertBSTD(TreeNode root) {
        Integer i = 25;
        Hold h=new Hold();
        h.total=28;
        reverseInOrderTraversalD(root,h);
        System.out.println(" uu "+h.total);
        return root;
    }

    public static void reverseInOrderTraversalD(TreeNode root,Hold hold) {
        if(root==null){return;}
        reverseInOrderTraversalD(root.right,hold);
        hold.total=hold.total- root.val;
        reverseInOrderTraversalD(root.left,hold);
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

       // levelOrder(convertBST(root));
        levelOrder(convertBSTD(root));

        System.out.println("fff");

    }
}
