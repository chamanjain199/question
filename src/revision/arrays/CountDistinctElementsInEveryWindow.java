package revision.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }
        ans.add(hashMap.size());
        for (int i = k; i < n; i++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
            Integer val = hashMap.get(A[i - k]);
            if (val == 1) {
                hashMap.remove(A[i - k]);
            } else {
                hashMap.put(A[i - k], val - 1);
            }
            ans.add(hashMap.size());
        }
        return ans;

    }
}
