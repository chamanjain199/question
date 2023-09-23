package revision.arrays;

import java.util.HashMap;

public class LargestSubarrayOf0Sand1S {
    int maxLen(int[] arr, int N) {
        HashMap<Integer, Integer> sumTack = new HashMap();
        sumTack.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i] == 1 ? 1 : -1;
            Integer found = sumTack.get(sum);
            if (found != null) {
                ans = Math.max(ans, i - found);
            } else {
                sumTack.put(sum, i);
            }

        }
        return ans;
    }
}
