package geeksForGeeks.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathToGivenNode {
    List<Integer> list = new ArrayList<>();

    public int[] solve(TreeNode A, int B) {
        preOrder(A, B);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public boolean preOrder(TreeNode node, int B) {
        if (node == null) {
            return false;
        }
        list.add(node.val);
        if (node.val == B) {
            return true;
        }
        if (preOrder(node.left, B) || preOrder(node.right, B)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        PathToGivenNode pathToGivenNode = new PathToGivenNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(pathToGivenNode.solve(root, 7)));
    }
}
