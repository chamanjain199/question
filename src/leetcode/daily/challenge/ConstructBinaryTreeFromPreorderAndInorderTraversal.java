package leetcode.daily.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static Map<Integer, Integer> inOrderValueIndexMap = new HashMap<>();
    static int preorderIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inOrderValueIndexMap.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < len; i++) {
            addNodeRec(root, preorder[i], inOrderValueIndexMap.get(preorder[i]), inOrderValueIndexMap);
        }
        return root;
    }

    public static TreeNode addNodeRec(TreeNode node, int value, int index, Map<Integer, Integer> map) {
        if (node == null) {
            return new TreeNode(value);
        }
        int currentNodeIndex = map.get(node.val);
        if (index < currentNodeIndex) {
            node.left = addNodeRec(node.left, value, index, map);
        } else {
            node.right = addNodeRec(node.right, value, index, map);
        }
        return node;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inOrderValueIndexMap.put(inorder[i], i);
        }
        return addNodeRec2(preorder, 0, len - 1);
    }

    public static TreeNode addNodeRec2(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int index = inOrderValueIndexMap.get(root.val);
        root.left = addNodeRec2(preorder, left, index - 1);
        root.right = addNodeRec2(preorder, index + 1, right);
        return root;
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            System.out.print(currentNode.val + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = buildTree2(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        levelOrderTraversal(root);
    }
}
