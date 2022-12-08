package geeksForGeeks.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int li;
    int pi;
    int val;

    Pair(int li, int pi, int val) {
        this.li = li;
        this.pi = pi;
        this.val = val;
    }
}

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int total = 0;
        for (int i = 0; i < K; i++) {
            priorityQueue.offer(new Pair(i, 0, arr[i][0]));
            total += arr[i].length;
        }
        ArrayList<Integer> ans = new ArrayList<>(total);
        while (!priorityQueue.isEmpty()) {
            Pair smallest = priorityQueue.poll();
            ans.add(smallest.val);
            if ((arr[smallest.li].length - 1) > (smallest.pi))
                priorityQueue.offer(new Pair(smallest.li, smallest.pi + 1, arr[smallest.li][smallest.pi + 1]));
        }
        return ans;


    }

    public static void main(String[] args) {

        System.out.println(mergeKArrays(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3));

    }
}
