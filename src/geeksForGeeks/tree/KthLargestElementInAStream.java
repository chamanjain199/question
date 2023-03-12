package geeksForGeeks.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int len = nums.length;
        this.k = k;
        for (int i = 0; i < len; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) priorityQueue.poll();
        return priorityQueue.peek();
    }

    public static void main(String[] args) {

        KthLargestElementInAStream obj = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        obj.add(3);


    }
}
