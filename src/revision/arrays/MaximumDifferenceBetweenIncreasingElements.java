package revision.arrays;

public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference2(int[] nums) {
        int n = nums.length;
        int rel = -1;
        int minValue = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > minValue) {   // because we needs to return -1 when there is no such case, if we do not put this if
                                        // then i case of same element we will get 0 and our output will be wrong
                rel = Math.max(rel, nums[i] - minValue);
            } else {
                minValue = Math.min(minValue, nums[i]);
            }
        }

        return rel;
    }
}
