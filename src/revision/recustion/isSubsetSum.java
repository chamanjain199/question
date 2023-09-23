package revision.recustion;

import java.util.Arrays;

public class isSubsetSum {
    static int dp[][];

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        dp = new int[sum][N];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return isSubsetSumRec(N, arr, sum, 0, 0);
    }

    static boolean isSubsetSumRec(int N, int arr[], int sum, int level, int temp) {
        if (level == N) {
            return sum == temp;
        }
        if (isSubsetSumRec(N, arr, sum, level + 1, temp + arr[level])) {
            return true;
        }
        return isSubsetSumRec(N, arr, sum, level + 1, temp);
    }

    static boolean isSubsetSumRec2(int N, int arr[], int sum, int level) {
        if (sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[level][sum] != -1) {
            return dp[level][sum] == 1;
        }
        for (int i = level; i < N; i++) {
            if (isSubsetSumRec2(N, arr, sum - arr[i], i + 1)) {
                dp[level][sum]=1;
                return true;
            }else{
                dp[level][sum]=2;
            }
        }
        dp[level][sum] = 2;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 9));
    }
}
