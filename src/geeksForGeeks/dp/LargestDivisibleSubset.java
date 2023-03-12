package geeksForGeeks.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] hash = new int[len];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        int max = 1;
        for (int i = 1; i < len; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && (1 + dp[j]) > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            arrayList.add(0, nums[lastIndex]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset obj=new LargestDivisibleSubset();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
