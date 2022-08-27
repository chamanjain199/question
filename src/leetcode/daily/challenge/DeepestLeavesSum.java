package leetcode.daily.challenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepestLeavesSum {

    int maxlevel=0;
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        inOrderTraversal(root, 0);
        return sum;
    }

    private void inOrderTraversal(TreeNode root, int level) {
        if (root.left == null && root.right == null && level==maxlevel) {
            sum = sum + root.val;
            return;
        }
        if (root.left == null && root.right == null && level > deepestLevel) {
            deepestLevel = level;
            sum = root.val;
        }
        if (root.left != null)
            inOrderTraversal(root.left, level + 1);
        if (root.right != null)
            inOrderTraversal(root.right, level + 1);
    }

    int deepestLevel = 0;

    public int deepestLeavesSum2(TreeNode root) {
        deepestLeavesSum2(root, 0);
        return sum;
    }

    public void deepestLeavesSum2(TreeNode root,int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && level == deepestLevel) {
            sum = sum + root.val;
        }

        if (root.left == null && root.right == null && level > deepestLevel) {
            deepestLevel = level;
            sum = root.val;
        }

        deepestLeavesSum2(root.left, level + 1);
        deepestLeavesSum2(root.right, level + 1);
    }

    public static void main(String[] args) {
        DeepestLeavesSum sb = new DeepestLeavesSum();
        TreeNode treeNode = new TreeNode(50);
        //treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(54);
        // treeNode.left.left = new TreeNode(4);
        //treeNode.left.right = new TreeNode(5);
        //treeNode.left.left.left = new TreeNode(7);

        treeNode.right.left = new TreeNode(98);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(34);
        System.out.println(sb.deepestLeavesSum(treeNode));
    }
}
