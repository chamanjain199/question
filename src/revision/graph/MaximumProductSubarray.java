package revision.graph;

public class MaximumProductSubarray {
    long maxProduct(int[] arr, int n) {
        long ans = Long.MIN_VALUE;
        long pre = 1;
        long suf = 1;
        for (int i = 0; i < n; i++) {
            if (pre == 0) {
                pre = 1;
            }
            if (suf == 0) {
                suf = 1;
            }
            pre = pre * arr[i];
            suf = suf * arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }
}
