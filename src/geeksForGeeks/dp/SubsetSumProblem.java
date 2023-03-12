package geeksForGeeks.dp;

import java.net.Socket;
import java.util.Arrays;

public class SubsetSumProblem {
    static int[][] dp;
    static int count = 0;

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        dp = new int[N][sum + 1];
        return isSubsetSumHelper(N, arr, sum, 0);
    }

    static boolean isSubsetSumHelper(int N, int arr[], int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        if (index >= N) {
            return false;
        }
        count++;
        if (dp[index][sum] != 0) {
            return dp[index][sum] == 1;
        }
        boolean notSelect = isSubsetSumHelper(N, arr, sum, index + 1);
        boolean select = isSubsetSumHelper(N, arr, sum - arr[index], index + 1);
        dp[index][sum] = (notSelect || select) ? 1 : 2;
        return dp[index][sum] == 1;
    }

    static boolean isSubsetSumHelper2(int N, int arr[], int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index == N - 1) {
            return arr[N - 1] == sum;
        }
        if (dp[index][sum] != 0) {
            return dp[index][sum] == 1;
        }
        boolean notSelect = isSubsetSumHelper2(N, arr, sum, index + 1);
        boolean select = false;
        if (sum >= arr[index]) select = isSubsetSumHelper2(N, arr, sum - arr[index], index + 1);
        dp[index][sum] = (notSelect || select) ? 1 : 2;
        return dp[index][sum] == 1;
    }

    static Boolean isSubsetSumButtomUp(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N][sum + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum) dp[0][arr[0]] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notSelect = dp[i - 1][j];
                boolean select = false;
                if (j >= arr[i]) select = dp[i - 1][j - arr[i]];
                dp[i][j] = (notSelect || select);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[N - 1][sum];

    }

    static Boolean isSubsetSumButtomUpSpaceOptimized(int N, int arr[], int sum) {
        boolean[] prev = new boolean[sum + 1];
        boolean[] cur;
        prev[0] = true;
        if (arr[0] <= sum) prev[arr[0]] = true;
        for (int i = 1; i < N; i++) {
            cur = new boolean[sum + 1];
            cur[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean notSelect = prev[j];
                boolean select = false;
                if (j >= arr[i]) select = prev[j - arr[i]];
                cur[j] = (notSelect || select);
            }
            prev = cur;
        }
        return prev[sum];

    }


    public static void main(String[] args) {
        // System.out.println(isSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 9));
        // System.out.println(count);
//        System.out.println(isSubsetSumButtomUp(2, new int[]{4,5}, 10));
         System.out.println(isSubsetSumButtomUp(6, new int[]{3, 34, 4, 12, 5, 2}, 9));

        System.out.println(count);
    }
}
