package revision.tree;

import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>();

    public void addNum(int num) {
        if (minQueue.isEmpty() || num <= minQueue.peek()) {
            minQueue.add(num);
        } else {
            maxQueue.add(num);
        }
        if (minQueue.size() > (maxQueue.size() + 1)) {
            maxQueue.add(minQueue.poll());
        } else if(maxQueue.size()>minQueue.size()){
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        Optional.of("d").get();
        if (minQueue.size() == maxQueue.size()) {
            return (double) minQueue.peek() / 2 + (double) maxQueue.peek() / 2;
        }
        return minQueue.peek();
    }
}
