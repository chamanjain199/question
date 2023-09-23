package revision.tree;

import java.util.PriorityQueue;
enum Week{


    privateSetterBankWEEK,
}

public class KthLargestElementInAStream {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(nums.length);
        this.k = k;
        for (int num : nums) {
            priorityQueue.add(num);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
