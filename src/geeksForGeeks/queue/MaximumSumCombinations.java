package geeksForGeeks.queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSumCombinations {
    public static int[] solve(int[] A, int[] B, int C) {
        int[] ans = new int[C];
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] + b[1] - (a[0] + a[1])));
        int N = A.length;
        int len = N - C;
        for (int i = N - 1; i >= len; i--) {
            pq.offer(new int[]{A[i], B[N - 1], N - 1});
        }
        int i = 0;
        while (i < C && !pq.isEmpty()) {
            int[] curr = pq.poll();
            ans[i] = curr[0] + curr[1];
            pq.offer(new int[]{curr[0], B[curr[2] - 1], curr[2] - 1});
            i++;
        }
        return ans;
    }

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        a.sort(null);
        b.sort(null);
        PriorityQueue<int[]> pq = new PriorityQueue<>((c, d) -> (d[0] + d[1] - (c[0] + c[1])));

        int len = n - k;
        for (int i = n - 1; i >= len; i--) {
            pq.offer(new int[]{a.get(i), b.get(n-1), n- 1});
        }
        int i = 0;
        while (i < k && !pq.isEmpty()) {
            int[] curr = pq.poll();
            ans.add( curr[0] + curr[1]);
            pq.offer(new int[]{curr[0], b.get(curr[2] - 1), curr[2] - 1});
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{36, 91, 43, 89, 7, 41, 43, 65, 49, 47, 6, 91, 30, 71, 51, 7, 2}, new int[]{36, 91, 43, 89, 7, 41, 43, 65, 49, 47, 6, 91, 30, 71, 51, 7, 2}, 17)));

    }
}
