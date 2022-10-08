
package geeksForGeeks.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        ans.add(List.of(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1] ) l++;
                        l++;
                    } else if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;


    }

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,0}));
    }

}
