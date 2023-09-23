package revision.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        inOrderTraversal(root, ans, new StringBuilder());
        return ans;
    }

    public void inOrderTraversal(TreeNode treeNode, List<String> ans, StringBuilder stringBuilder) {
        if (treeNode != null) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(treeNode.val);
            } else {
                stringBuilder.append("->").append(treeNode.val);
            }
            inOrderTraversal(treeNode.left, ans, stringBuilder);
            inOrderTraversal(treeNode.right, ans, stringBuilder);
            if (treeNode.left == null && treeNode.right == null) {
                ans.add(stringBuilder.toString());
            }
            if (stringBuilder.length() > 3) {
                System.out.println(stringBuilder);
                stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length());
            }
        }
    }

    public static TreeNode createTree(Integer[] inorder, int index) {
        if (index >= inorder.length || inorder[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(inorder[index]);
        node.left = createTree(inorder, 2 * index + 1);
        node.right = createTree(inorder, 2 * index + 2);

        return node;
    }


    public static void main(String[] args) {
        BinaryTreePaths obj = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Integer[] inorder = {37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8};

        TreeNode root2 = createTree(inorder, 0);
        obj.binaryTreePaths(root2);
    }
}
