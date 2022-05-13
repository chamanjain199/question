package leetcode.biweekly.contest;


public class FindTriangularSumOfAnArray {
    public static int triangularSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int temp[] = new int[nums.length - 1];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            temp[i] = (nums[i] + nums[i + 1]) % 10;
            if (i == len - 2) {
                if (temp.length > 1) {
                    nums = temp;
                    len = temp.length;
                    temp = new int[len - 1];
                    i = -1;
                }
            }
        }


        return temp[0];
    }

    public static void main(String[] args) {
        triangularSum(new int[]{1, 2, 3, 4, 5});
    }
}
