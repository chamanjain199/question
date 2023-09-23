package revision.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//left , root , right
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderIterative(root, ans);
        return ans;
    }

    public void inOrder(TreeNode node, List<Integer> ans) {
        if (node != null) {
            inOrder(node.left, ans);
            ans.add(node.val);
            inOrder(node.right, ans);
        }
    }

    public void inOrderIterative(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.peek();
            if (node.left != null) {
                nodes.push(node.left);
                node.left = null;
            } else {
                ans.add(node.val);
                nodes.pop();
                if (node.right != null) {
                    nodes.push(node.right);
                    node.right = null;
                }
            }
        }
    }

    public void inOrderIterative2(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> nodes = new Stack<>();
        while (true) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                if (nodes.isEmpty()) {
                    break;
                }
                root = nodes.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(obj.inorderTraversal(root));
    }
}
