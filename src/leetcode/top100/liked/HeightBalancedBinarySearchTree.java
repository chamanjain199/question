package leetcode.top100.liked;

public class HeightBalancedBinarySearchTree {


    private static void addNodeOld(int arr[], int l, int r, TreeNode node) {

        if (l < r) {
            int mid = (l + r) / 2;
            node.val = arr[mid];
            if (l != mid) {
                node.left = new TreeNode();
            }
            if ((mid + 1) != r) {
                node.right = new TreeNode();
            }
            addNodeOld(arr, l, mid, node.left);
            addNodeOld(arr, mid + 1, r, node.right);
        }

    }

    private static TreeNode addNode(int arr[], int l, int r) {

        if (l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode();
        node.val = arr[mid];
        node.left = addNode(arr, l, mid);
        node.right = addNode(arr, mid + 1, r);
        return node;
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return addNode(nums, 0, nums.length);
    }

    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode tr = sortedArrayToBST(arr);

    }
}
