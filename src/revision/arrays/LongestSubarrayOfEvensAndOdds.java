package revision.arrays;

public class LongestSubarrayOfEvensAndOdds {
    public static int maxEvenOdd(int arr[], int n) {
        boolean isPreEven = ((arr[n - 1] & 1) == 0);
        int ans = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            boolean isCurrentEven = ((arr[n - 1] & 1) == 0);
            if (isPreEven == isCurrentEven) {
                ans = Math.max(count, ans);
                count = 0;
            }
            isPreEven = isCurrentEven;
            count++;
        }
        ans = Math.max(count, ans);
        return ans;
    }
}
