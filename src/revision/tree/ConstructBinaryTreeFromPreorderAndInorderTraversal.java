package revision.tree;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) { //not optimal
        Map<Integer, Integer> mapping = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            mapping.put(inorder[i], i);
        }
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int curIndex = 0;
        int nextIndex = 0;
        TreeNode cur;
        for (int i = 1; i < len; i++) {
            cur = root;
            while (cur != null) {
                curIndex = mapping.get(cur.val);
                nextIndex = mapping.get(preorder[i]);
                if (nextIndex < curIndex) {
                    if (cur.left == null) {
                        cur.left = new TreeNode(preorder[i]);
                        cur = null;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = new TreeNode(preorder[i]);
                        cur = null;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        return root;
    }


    public TreeNode buildTreeOptimal(int[] preorder, int[] inorder) { //optimal
        Map<Integer, Integer> mapping = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            mapping.put(inorder[i], i);
        }
        if (len == 0) {
            return null;
        }
        return buildTreeOptimalRec(preorder, mapping, 0, 0, len - 1, len);

    }

    public TreeNode buildTreeOptimalRec(int[] preorder, Map<Integer, Integer> map,
                                        int index, int left, int right, int len) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int newRootIndex = map.get(root.val);
        root.left = buildTreeOptimalRec(preorder, map, index + 1, left, newRootIndex - 1, len);
        root.right = buildTreeOptimalRec(preorder, map, index + 1 + newRootIndex - left, newRootIndex + 1, right, len);
        return root;
    }

    int parentIndex = 0;
    Map<Integer, Integer> map;
    int len;
    public TreeNode buildTreeOptimal2(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, len - 1);
    }
    TreeNode constructTree(int[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[parentIndex++]);
        int rootNodeIndex = map.get(root.val);
        root.left = constructTree(preOrder, left, rootNodeIndex - 1);
        root.right = constructTree(preOrder, rootNodeIndex+1,right);
        return root;
    }
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal o = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        o.buildTreeOptimal(preOrder, inOrder);

    }
}
