package leetcode.top100.liked;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return Integer.valueOf(sb.toString()) + 1;
    }

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{9}));

    }
}
