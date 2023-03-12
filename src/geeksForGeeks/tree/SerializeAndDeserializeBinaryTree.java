package geeksForGeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return sb.toString();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                sb.append("#");
            } else {
                sb.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            sb.append(",");
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        TreeNode root = new TreeNode();
        String[] levelOrder = data.split(",");
        if (data.isEmpty()) {
            return null;
        } else {
            root.val = Integer.parseInt(levelOrder[0]);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curIndex = 1;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (!levelOrder[curIndex].equals("#")) {
                curNode.left = new TreeNode(Integer.parseInt(levelOrder[curIndex]));
                queue.add(curNode.left);
            }
            curIndex++;
            if (!levelOrder[curIndex].equals("#")) {
                curNode.right = new TreeNode(Integer.parseInt(levelOrder[curIndex]));
                queue.add(curNode.right);
            }
            curIndex++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String output = serialize(root);
        System.out.println(output);
    }
}
