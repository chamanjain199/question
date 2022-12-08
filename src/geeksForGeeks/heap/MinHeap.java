package geeksForGeeks.heap;

public class MinHeap {
    int capacity;
    int[] elements;
    int currentPointer;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity + 1];
        currentPointer = 0;
    }

    public void insert(int ele) {
        currentPointer++;
        int parent = currentPointer / 2;
        int currentPointerCopy = currentPointer;
        while (parent > 0 && ele < elements[parent]) {
            elements[currentPointerCopy] = elements[parent];
            currentPointerCopy = parent;
            parent = parent / 2;
        }
        elements[currentPointerCopy] = ele;
    }

    private static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void delete() {
        elements[1] = elements[currentPointer];
        elements[currentPointer] = 0;
        currentPointer--;
        int i = 1;
        int leftChildIndex = i * 2;
        int rightChildIndex = leftChildIndex + 1;
        while (leftChildIndex <= currentPointer) {
            int smallest = i;
            if (elements[leftChildIndex] < elements[smallest]) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex <= currentPointer && elements[rightChildIndex] < elements[smallest]) {
                smallest = rightChildIndex;
            }
            if (smallest == i) {
                break;
            } else {
                swap(i, smallest, elements);
                i = smallest;
            }
        }
    }
}
