package geeksForGeeks.tree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l>r){
            return null;
        }
        int mid=(l+r)>>1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,l,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode addNode(int arr[], int l, int r) {

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
    public TreeNode sortedArrayToBST0(int[] nums) {
        return addNode(nums, 0, nums.length);
    }
    public static void main(String[] args) {

    }
}
