package geeksForGeeks.sorting;

import java.util.Arrays;

public class MinimumDifferencePair {
    public int minimum_difference(int[] nums)
    {
        Arrays.sort(nums);
        int minDiff=Integer.MAX_VALUE;
        for (int i = 1; i < nums.length ; i++) {
            minDiff=Math.min(nums[i]-nums[i-1],minDiff);
        }
        return minDiff;
    }
}
