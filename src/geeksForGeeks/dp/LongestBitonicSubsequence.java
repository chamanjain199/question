package geeksForGeeks.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int LongestBitonicSequence(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[len];
        Arrays.fill(dp2, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
                }
            }
        }
        int maxi = 1;
        for (int i = 0; i < len; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }

    public static void main(String[] args) {

    }
}
