package geeksForGeeks.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    private static int j;

    public static List<List<Integer>> kSmallestPairsTLE(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        long sum;
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for (int i = 0; i < len2; i++) {
            ans.add(i, List.of(nums1[0], nums2[i]));
        }
        List<Integer> subList;

        long tempSum;
        for (int i = 1; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                sum = nums1[i] + nums2[j];
                subList = ans.get(ans.size() - 1);
                tempSum = subList.get(0) + subList.get(1);
                if (sum > tempSum && ans.size() == k) {
                    break;
                }
                int size = ans.size() - 1;
                while (size >= 0) {
                    subList = ans.get(size);
                    tempSum = subList.get(0) + subList.get(1);
                    if (sum < tempSum) {
                        size--;
                    } else {
                        ans.add(size + 1, List.of(nums1[i], nums2[j]));
                        break;
                    }
                }
                if (ans.size() > k) {
                    ans.remove(ans.size() - 1);
                }
            }
        }
        return ans;

    }

    public static List<List<Integer>> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int len1 =Math.min(nums1.length,k);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        if(nums1.length==0 || nums2.length==0 || k==0) return ans;

        for (int i = 0; i < len1; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-->0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            ans.add(List.of(cur[0], cur[1]));
            if(cur[2] == nums2.length-1) continue;
            minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ans;

    }


    public static void main(String[] args) {
        //  System.out.println(kSmallestPairs(new int[]{-10,-4,0,0,6}, new int[]{3,5,6,7,8,100}, 10));
        System.out.println(kSmallestPairsTLE(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));

    }
}
