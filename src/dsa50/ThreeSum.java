package dsa50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int sum = -nums[i];
                int lo = i + 1;
                int hi = len - 1;
                while (lo < hi) {
                    int tsum = nums[lo] + nums[hi];
                    if (tsum == sum) {
                        ans.add(List.of(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (tsum < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ans;
    }
}
