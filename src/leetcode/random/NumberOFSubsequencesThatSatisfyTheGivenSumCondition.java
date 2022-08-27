package leetcode.random;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/submissions/
public class NumberOFSubsequencesThatSatisfyTheGivenSumCondition {
    public static int numSubseq(int[] nums, int target) {
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count++;
            }
            for (int j = 0; j < nums.length; j++) {
                if (i!= j && nums[i] + nums[j] <= target) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22);
        System.out.println(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));

    }
}
