package revision.tree;


import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "#";
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String leftNodeVal = nodes[index++];
            String rightNodeVal = nodes[index++];
            if (!leftNodeVal.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(leftNodeVal));
                queue.add(node.left);
            }
            if (!rightNodeVal.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(rightNodeVal));
                queue.add(node.right);
            }
        }
        return root;

    }
}
