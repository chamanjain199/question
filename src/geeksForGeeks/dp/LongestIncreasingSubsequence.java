package geeksForGeeks.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    int dp[][];


    public int lengthOfLIS(int[] nums) {

        int len = nums.length;

        dp = new int[len][len + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return lengthOfLISTopDown(nums, 0, -1);

    }

    public int lengthOfLISTopDown(int[] nums, int index, int prevInx) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index][prevInx + 1] != -1) {
            return dp[index][prevInx + 1];
        }
        int notTake = lengthOfLISTopDown(nums, index + 1, prevInx);
        int take = 0;
        if (prevInx == -1 || nums[index] > nums[prevInx]) {
            take = 1 + lengthOfLISTopDown(nums, index + 1, index);
        }
        return dp[index][prevInx + 1] = Math.max(take, notTake);
    }

    public int lengthOfLISBottomUp(int[] nums) {
        int len = nums.length;
        dp = new int[len + 1][len + 1];
        for (int index = len - 1; index >= 0; index--) {
            for (int prevIdx = index - 1; prevIdx >= -1; prevIdx--) {
                int notTake = dp[index + 1][prevIdx + 1];
                int take = 0;
                if (prevIdx == -1 || nums[index] > nums[prevIdx]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][prevIdx + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public int lengthOfLISBottomUpSpaceOptimized(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int[] cur = new int[len + 1];

        for (int index = len - 1; index >= 0; index--) {
            for (int prevIdx = index - 1; prevIdx >= -1; prevIdx--) {
                int notTake = dp[prevIdx + 1];
                int take = 0;
                if (prevIdx == -1 || nums[index] > nums[prevIdx]) {
                    take = 1 + dp[index + 1];
                }
                cur[prevIdx + 1] = Math.max(take, notTake);
            }
            dp = cur;
        }
        return dp[0];
    }

    public int lengthOfLI(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public int lengthOfLISOptimized(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int index = 0;
        dp[0] = nums[0];

        for (int num : nums) {
            if (num > dp[index]) {
                dp[++index] = num;
            } else {
                int j = index;
                while (j >= 0 && dp[j] >= num) {
                    j--;
                }
                dp[j + 1] = num;
            }
        }
        return index + 1;
    }


    static int LowerBound(List<Integer> a, int x) { // x is the target value or key
        int l=-1,r=a.size();
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a.get(m)>=x) r=m;
            else l=m;
        }
        return r;
    }

    public int lengthOfLISSuperOptimized(int[] nums) {
        List<Integer> lis = new ArrayList<>(nums.length);
        int len = nums.length;
        lis.add(nums[0]);
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                lis.set(LowerBound(lis, num), num);
            }
        }
        return lis.size();

    }


    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]) {

        int dp[] = new int[N];
        int lastIndex = 1;
        Arrays.fill(dp, 1);
        int max = 1;
        int[] hash = new int[N];
        for (int i = 0; i < N; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && (1 + dp[j]) > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        int ans = dp[lastIndex];
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[lastIndex]);
        ans--;
//        for (int i = lastIndex - 1; i >= 0 && ans > -1; i--) {
//            if (dp[i] == ans) {
//                arrayList.add(0, dp[i]);
//                ans--;
//            }
//        }

        while (ans > 0) {
            lastIndex = hash[lastIndex];
            arrayList.add(0, arr[lastIndex]);
            ans--;
        }
        return arrayList;
    }

    public static void main(String[] args) {
              boolean a=true;
              a|=false;
        System.out.println(a);
    }

}
