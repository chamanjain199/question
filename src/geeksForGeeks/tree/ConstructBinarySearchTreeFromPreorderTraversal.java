package geeksForGeeks.tree;

import java.util.Stack;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int curIndex = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (curIndex < preorder.length) {
            int newVal = preorder[curIndex++];
            if (newVal < cur.val) {
                cur.left = new TreeNode(newVal);
                cur = cur.left;
                stack.push(cur);
            } else {
                if (stack.peek().val > newVal) {
                    cur.right = new TreeNode(newVal);
                    cur = cur.right;
                    stack.push(cur);
                } else {
                    while (!stack.isEmpty() && stack.peek().val < newVal) {
                        cur = stack.pop();
                    }
                    cur.right = new TreeNode(newVal);
                    cur = cur.right;
                    stack.push(cur);
                }
            }
        }
        return root;
    }

    static int index = 0;

    public static TreeNode bstFromPreorderRec(int[] preorder) {
        return bstFromPreorderRec(preorder, Integer.MAX_VALUE);

    }

    public static TreeNode bstFromPreorderRec(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstFromPreorderRec(preorder, root.val);
        root.right = bstFromPreorderRec(preorder, bound);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{19, 4, 8, 11};
        bstFromPreorderRec(arr);
    }
}
