package revision.tree;


import java.util.ArrayList;
import java.util.Map;

public class LeftViewOfBinaryTree {
    int currLevel = -1;

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrderTraversal(root, ans, 0);
        return ans;
    }

    ArrayList<Integer> leftView2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (root != null) {
            ans.add(root.data);
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return ans;
    }

    public void inOrderTraversal(Node node, ArrayList<Integer> ans, int level) {
        if (node != null) {
            if (currLevel < level) {
                ans.add(node.data);
                currLevel++;
            }
            inOrderTraversal(node.left, ans, level + 1);
            inOrderTraversal(node.right, ans, level + 1);
        }
    }
}
