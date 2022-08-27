package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        finalList.add(List.of(root.val));
        while (!queue.isEmpty()) {

            int childs = queue.size();

            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < childs; i++) {
                TreeNode currentNode = queue.remove();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    subList.add(currentNode.left.val);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    subList.add(currentNode.right.val);
                }
            }
            if (!subList.isEmpty())
                finalList.add(new ArrayList<>(subList));
        }
        return finalList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
//        root.right = new TreeNode();
//        root.right.val = 3;
        root.left.left = new TreeNode();
        root.left.left.val = 3;
//        root.right.right=new TreeNode();
//        root.right.right.val=5;
        root.left.left.left = new TreeNode();
        root.left.left.left.val = 4;
        root.left.left.left.left = new TreeNode();
        root.left.left.left.left.val = 5;
        System.out.println(1 << 1);
        System.out.println(levelOrder(root));
    }
}
