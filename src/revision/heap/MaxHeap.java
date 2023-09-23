package revision.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] maxHeap;
    int size;
    int curIndex = 1;

    MaxHeap(int size) {
        maxHeap = new int[size + 1];
        this.size = size;
    }

    public void add(int ele) {
        if (curIndex == maxHeap.length ) {
            return;
        }
        maxHeap[curIndex] = ele;
        heapify(curIndex);
        curIndex++;
    }

    public int poll() {
        if (curIndex == 0) {
            return -1;
        }
        int val = maxHeap[1];
        maxHeap[1] = maxHeap[curIndex - 1];
        maxHeap[curIndex - 1]=Integer.MIN_VALUE;
        heapifyTopToBottom();
        curIndex--;
        return val;

    }

    private void heapifyTopToBottom() {
        int largeIndex = 1;
        int parentIndex = 1;
        while (largeIndex < maxHeap.length) {
            int left = parentIndex * 2;
            int right = parentIndex * 2 + 1;
            if (right < maxHeap.length) {
                largeIndex = Math.max(maxHeap[left], maxHeap[right]) == maxHeap[left] ? left : right;
            } else if (left < maxHeap.length) {
                largeIndex = left;
            } else {
                return;
            }
            if (maxHeap[largeIndex] > maxHeap[parentIndex]) {
                swap(largeIndex, parentIndex);
                parentIndex = largeIndex;
            } else {
                return;
            }
        }
    }


    private void heapify(int curIndex) {
        while (curIndex > 1) {
            int parent = curIndex / 2;
            if (maxHeap[parent] < maxHeap[curIndex]) {
                swap(parent, curIndex);
                curIndex = parent;
            } else {
                return;
            }
        }
    }

    private void swap(int i, int j) {
        int t = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {-1,-1};
        MaxHeap maxHeap1 = new MaxHeap(ints.length);
        for (int num : ints) {
            maxHeap1.add(num);
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(maxHeap1.poll());
        }
    }
}
