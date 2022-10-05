package geeksForGeeks.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LargestSubarrayOf0sAnd1s {
    static int maxLen(int[] arr, int N) {
        N=arr.length;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int largestSeq = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + (arr[i] == 1 ? 1 : -1);
            Integer index = sumToIndex.get(sum);
            if (index == null) {
                sumToIndex.put(sum, i);
            } else {
                largestSeq = Math.max(largestSeq, i - index);
            }

        }
        return largestSeq;
    }

    public static void main(String[] args) {
        //largest subarray with equal 1 and 0
        System.out.println(maxLen(new int[]{1,1,1,0,0}, 0));
    }
}
