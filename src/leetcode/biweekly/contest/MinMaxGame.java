package leetcode.biweekly.contest;

public class MinMaxGame {
    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int log2 = (int) (Math.log(nums.length) / Math.log(2));

        for (int k = 0; k < log2; k++) {
            int[] arr = new int[nums.length / 2];
            for (int i = 0, j = 0; i < nums.length; i = i + 2, j++) {
                if ((j & 1) == 0)
                    arr[j] = Math.min(nums[i], nums[i + 1]);
                else {
                    arr[j] = Math.max(nums[i], nums[i + 1]);
                }
            }
            nums = arr;
        }

        return nums[0];

    }

    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[]{1,3,5,2,4,8,2,2}));
    }
}
