package geeksForGeeks.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int parentIndex = 0;
    Map<Integer, Integer> map;
    int len;

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, len - 1);
    }

    TreeNode constructTree(int[] preOrder, int left, int right) {
        if (left < right) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[parentIndex++]);
        int rootNodeIndex = map.get(root.val);
        root.left = constructTree(preOrder, 0, rootNodeIndex - 1);
        root.right = constructTree(preOrder, rootNodeIndex, len - 1);
        return root;
    }


    public static void main(String[] args) {

    }
}
