package leetcode.top100.liked;
import java.util.Arrays;

class BinaryHeap {
    String type;
    int arr[];
    int index;

    BinaryHeap(int size, String type) {
        arr = new int[size + 1];
        this.type = type;
        index = 1;
    }

    public void add(int value) {
        arr[index] = value;
        balanceBottomToTop(index++);
    }

    void balanceBottomToTop(int index) {
        if (index <= 1) {
            return;
        }
        int parent = 0;
        parent = index / 2;

        if (type == "MIN") {
            if (arr[parent] > arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
            }
        } else {
            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
            }
        }
        balanceBottomToTop(parent);
    }

    public int extract() {
        int temp = arr[1];
        arr[1] = arr[--index];
        heapifyTopToBottom(1);
        return temp;
    }

    private void heapifyTopToBottom(int parent) {

        int left = parent * 2;
        int right = parent * 2 + 1;
        int swapIndex = 0;
        if (this.index < left) {
            return;
        }
        if (type == "MIN") {
            if (left == this.index) {
                if (arr[left] < arr[parent]) {
                    int temp = arr[left];
                    arr[left] = arr[parent];
                    arr[parent] = temp;
                }
                return;
            }
            if (arr[left] < arr[right]) {
                swapIndex = left;
            } else {
                swapIndex = right;
            }
            if (arr[swapIndex] < arr[parent]) {
                int temp = arr[swapIndex];
                arr[swapIndex] = arr[parent];
                arr[parent] = temp;
            }

        } else {
            if (left == this.index) {
                if (arr[left] > arr[parent]) {
                    int temp = arr[left];
                    arr[left] = arr[parent];
                    arr[parent] = temp;
                }
                return;
            }
            if (arr[left] > arr[right]) {
                swapIndex = left;
            } else {
                swapIndex = right;
            }
            if (arr[swapIndex] > arr[parent]) {
                int temp = arr[swapIndex];
                arr[swapIndex] = arr[parent];
                arr[parent] = temp;
            }

        }
        heapifyTopToBottom(swapIndex);
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}

class QuickSort {

    private static int partitionedArray(int[] arr, int start,  int end) {
        int i = end+1;
        for (int j = end; j >=start; j--) {
            if (arr[j] >=arr[start]) {
                i--;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
    private static void quickSort(int arr[], int start, int end) {
        if(start>end){
            return;
        }
        int pivot = partitionedArray(arr, start,end);
        quickSort(arr,  start, pivot-1);
        quickSort(arr,  pivot+1, end);
    }
    public static void main(String[] args) {
        int arr[]=new int[]{2,4,3,1,5,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        BinaryHeap bh = new BinaryHeap(arr.length, "MAX");
        for (int i = 0; i < arr.length; i++) {
            bh.add(arr[i]);
        }
        bh.print();

        for (int i = 0; i < k - 1; i++) {
            bh.extract();
        }
        return bh.extract();
    }

    public static void main(String[] args) {

        System.out.println(kthSmallest(new int[]{2, 1}, 0, 6, 1));

    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return exec(nums, 0, nums.length - 1, k);
    }

    int exec(int[] nums, int start, int end, int k) {
        int len = end - start + 1;
        int index = start + (end - start) / 2;
        int pivot = nums[index];
        swap(nums, index, end);

        int left = start;
        int right = end;
        while(left < right) {
            while(left < right && nums[left] <= pivot)
                left++;
            if(left < right) {
                nums[right] = nums[left];
                right--;
            }

            while(left < right && nums[right] >= pivot)
                right--;
            if(left < right) {
                nums[left] = nums[right];
                left++;
            }
        }
        nums[left] = pivot;

        if(end - left + 1 == k)
            return pivot;
        else if (end - left + 1 > k) {
            return exec(nums, left + 1, end, k);
        } else {
            return exec(nums, start, left - 1, k - (end - left + 1));
        }
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
