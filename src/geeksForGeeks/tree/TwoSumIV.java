package geeksForGeeks.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        int start = 0;
        int end = list.size() - 1;
        int tempSum = 0;
        while (start < (end - 1)) {
            tempSum = list.get(start);
            tempSum += list.get(end);
            if (tempSum > k) {
                end--;
            } else if (tempSum < k) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }

    public static void main(String[] args) {

    }
}
