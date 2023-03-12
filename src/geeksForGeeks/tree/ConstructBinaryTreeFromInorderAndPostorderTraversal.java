package geeksForGeeks.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int parentIndex = 0;
    Map<Integer, Integer> map;
    int len;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        len = inorder.length;
        parentIndex=len-1;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(postorder, 0, len - 1);
    }
    TreeNode constructTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[parentIndex--]);
        int rootNodeIndex = map.get(root.val);
        root.right = constructTree(postorder, rootNodeIndex+1,right);
        root.left = constructTree(postorder, left, rootNodeIndex - 1);
        return root;
    }
    public static void main(String[] args) {

    }
}
