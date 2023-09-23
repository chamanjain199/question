package revision.recustion;

import java.util.Arrays;
import java.util.Map;

///https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static int m = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if ((nums[left] + nums[right]) < target) {
                count = (int) (count + Math.pow(2, right - left))%m;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition obj = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        System.out.println(obj.numSubseq(new int[]{3, 5, 6, 7}, 9));
    }
}
