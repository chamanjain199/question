package geeksForGeeks.dp;

import java.util.Arrays;

public class PartitionsWithGivenDifference {
    int dp[][];
    int mod=(int)1e9+7;

    public int countPartitions(int n, int d, int arr[]) {
        int total = 0;
        for (int s : arr) {
            total += s;
        }
        int target = (total - d) / 2;
        if(total-d<0) return 0;
        if((total-d)%2==1) return 0;

        dp = new int[n][target+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return numberOfSubsetsWithSumK(n-1, target, arr);
    }

    private int numberOfSubsetsWithSumK(int index, int k, int[] nums) {
        if (index == -1) {
            return k == 0 ? 1 : 0;
        }
        if (dp[index][k] != -1) {
            return dp[index][k];
        }
        int notPick = numberOfSubsetsWithSumK(index - 1, k, nums);
        int pick = 0;
        if (nums[index] <= k) {
            pick = numberOfSubsetsWithSumK(index - 1, k - nums[index], nums);
        }
        return dp[index][k] = (pick + notPick)%mod;
    }
    public static void main(String[] args) {
        PartitionsWithGivenDifference obj=new PartitionsWithGivenDifference();
        System.out.println(obj.countPartitions(17,2,new int[]{2,40,6,6,43,44,10,32,12,12,26,31,48,14,38,42,25}));
    }

}
