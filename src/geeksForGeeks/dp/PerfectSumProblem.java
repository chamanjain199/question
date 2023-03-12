package geeksForGeeks.dp;

import java.util.Arrays;

public class PerfectSumProblem {
    int[][] dp;
    int mod = (int)1e9+7;

    public int perfectSum(int[] nums, int target) {
        return perfectSumRec(nums.length - 1, nums, target);
    }

    public int perfectSumRec(int index, int[] nums, int target) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }
        int notPick = perfectSumRec(index - 1, nums, target);
        int pick = 0;
        if (nums[index] <= target) {
            pick = perfectSumRec(index - 1, nums, target - nums[index]);
        }
        return pick + notPick;
    }

    public int perfectSumTopDown(int arr[],int n, int sum)
    {
        dp=new int[n][sum+1];
        for (int[] arr1 : dp) {
            Arrays.fill(arr1, -1);
        }
        return perfectSumTopDown(n-1 , sum,arr);
    }
    public int perfectSumTopDown(int index,  int target,int[] arr) {

        if (index == -1) {
            return target == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notPick = perfectSumTopDown(index - 1,  target, arr);
        int pick = 0;
        if (arr[index] <= target) {
            pick = perfectSumTopDown(index - 1,  target - arr[index],arr);
        }
        return dp[index][target] = (pick + notPick)%mod;
    }


    public int numSubseqTopDown(int index, int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            return nums[0] == target ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notPick = numSubseqTopDown(index - 1, nums, target);
        int pick = 0;
        if (nums[index] <= target) {
            pick = numSubseqTopDown(index - 1, nums, target - nums[index]);
        }
        return dp[index][target] = pick + notPick;
    }

    public int numSubseqTabulation(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (num[0] <= tar) dp[0][num[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= tar; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (num[i] <= j) {
                    pick = dp[i - 1][j - num[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }

        return dp[n - 1][tar];
    }

    public static void main(String[] args) {
        PerfectSumProblem obj = new PerfectSumProblem();
        System.out.println(obj.perfectSum(new int[]{1, 0, 2}, 2));
        //System.out.println(obj.numSubseq(new int[]{1, 2, 0}, 2));

        //9 ,7, 0, 3, 9, 8,5 ,7
        //5 14
        //7 0 3 6 5

    }
}
