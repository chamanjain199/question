package revision.arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public int maxCircularSubArray(int[] nums) {
        int maxSub = maxSubArray(nums);
        if (maxSub < 0) {
            return maxSub;
        }
        int total = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            total += nums[i];
            nums[i] *= -1;
        }
        int minSub = maxSubArray(nums);
        return Math.max(maxSub, total + minSub);
    }
}
