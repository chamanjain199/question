package geeksForGeeks.heap;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        MinHeap maxHeap = new MinHeap(10);
        maxHeap.insert(10);
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.insert(20);
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.insert(30);
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.delete();
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.insert(10);
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.delete();
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.insert(8);
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.insert(38);
        System.out.println(Arrays.toString(maxHeap.elements));




    }
}
