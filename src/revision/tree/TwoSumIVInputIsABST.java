package revision.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        int start = 0;
        int end = list.size() - 1;
        int sum = 0;
        while (start < end) {
            sum = list.get(start) + list.get(end);
            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            }else{
                return true;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root != null) {
            inOrderTraversal(root.left, ans);
            ans.add(root.val);
            inOrderTraversal(root.right, ans);
        }
    }
}
