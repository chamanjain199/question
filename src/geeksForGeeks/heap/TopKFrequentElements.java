package geeksForGeeks.heap;

import java.util.Arrays;

class MyMaxHeap {
    class Node {
        int ele;
        int freq;

        Node(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }

    Node[] elements;
    int currentIdx;

    public MyMaxHeap(int capacity) {
        elements = new Node[capacity + 1];
    }

    public void insert(int ele, int freq) {
        currentIdx++;
        int parent = currentIdx / 2;
        int i = currentIdx;
        while (parent > 0 && elements[parent].freq < freq) {
            elements[i] = elements[parent];
            i = parent;
            parent = parent / 2;
        }
        while (parent > 0 && elements[parent].freq == freq && elements[parent].ele < ele) {
            elements[i] = elements[parent];
            i = parent;
            parent = parent / 2;
        }
        elements[i] = new Node(ele, freq);
    }

    private void swap(int i, int j, Node arr[]) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int delete() {
        Node res = elements[1];
        elements[1] = elements[currentIdx];
        elements[currentIdx] = null;
        currentIdx--;
        int i = 1;
        int leftChild = i * 2;
        int rightChild = leftChild + 1;
        while (leftChild <= currentIdx) {
            int largest = i;
            if (elements[leftChild].freq > elements[largest].freq) {
                largest = leftChild;
            }
            if (rightChild <= currentIdx && elements[rightChild].freq > elements[largest].freq) {
                largest = rightChild;
            }
            if (largest == i) {
                break;
            } else {
                swap(largest, i, elements);
                i = largest;
                leftChild = i * 2;
                rightChild = leftChild + 1;
            }
        }
        return res.ele;
    }

}

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < lo)
                lo = num;

            if (num > hi)
                hi = num;
        }
        int len = hi - lo + 1;
        int[] arrWithFreq = new int[hi - lo + 1];
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            arrWithFreq[nums[i] - lo]++;
        }
        MyMaxHeap maxHeap = new MyMaxHeap(len);
        for (int i = 0; i < len; i++) {
            if (arrWithFreq[i] != 0) {
                maxHeap.insert((i + lo), arrWithFreq[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.delete();
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{ 8 ,1 ,1 ,2 ,2 ,3 ,3 ,3 ,4}, 2)));
    }

}
