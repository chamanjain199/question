package geeksForGeeks.dp;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int ans = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for (int i = 1; i < len; i++) {
            int temp = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(maxProd * nums[i], minProd * nums[i]));
            maxProd = temp;
            ans = Math.max(ans, maxProd);

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-5, 0, 2}));
    }
}
