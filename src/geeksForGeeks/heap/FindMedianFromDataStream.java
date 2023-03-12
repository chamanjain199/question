package geeksForGeeks.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    List<Integer> stream;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public FindMedianFromDataStream() {
        stream = new ArrayList<>();
    }

    public void addNumOptimized(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {  //put smaller number in max heap  because to find median we need max from smaller numbers
            maxHeap.add(num);
        } else {
            minHeap.add(num);   // put greater number in min heap because to find median we need min from greater numbers
        }

        //ex [10,20,30,40]
        // from greater 30,40  be need min ( that is 30)
        // from smaller number 10, 20 we need max (that is 20)




    }

    public double findMedianOptimized() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) minHeap.peek() / 2) + (double) maxHeap.peek() / 2;
        }
        return maxHeap.peek();
    }

    public void addNum(int num) {

        int start = 0;
        int end = stream.size() - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (stream.get(mid) > num) {
                end = mid - 1;
            } else if (stream.get(mid) < num) {
                start = mid + 1;
            } else {
                start = mid;
                break;
            }
        }

        stream.add(start, num);

    }

    public double findMedian() {
        int n = stream.size();
        int half = n / 2;
        if (n == 0) return 0;
        if ((n & 1) == 1) return stream.get(half);
        return (((double) stream.get(half) + (double) stream.get(half - 1))) / 2;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();

        findMedianFromDataStream.addNum(1);
        System.out.println(findMedianFromDataStream.findMedian());

        findMedianFromDataStream.addNum(2);
        System.out.println(findMedianFromDataStream.findMedian());

        findMedianFromDataStream.addNum(3);
        System.out.println(findMedianFromDataStream.findMedian());

        findMedianFromDataStream.addNum(11);
        System.out.println(findMedianFromDataStream.findMedian());
//
//        findMedianFromDataStream.addNum(-5);
//        System.out.println(findMedianFromDataStream.findMedian());

    }
}
