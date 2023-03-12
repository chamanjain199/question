package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }
        ans.add(hashMap.size());
        int j = 0;
        for (int i = k; i < n; i++, j++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
            Integer val = hashMap.get(A[j]);
            if (val == 1) {
                hashMap.remove(A[j]);
            } else {
                hashMap.put(A[j], val - 1);
            }
            ans.add(hashMap.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27
        }, 14, 5));
    }
}
