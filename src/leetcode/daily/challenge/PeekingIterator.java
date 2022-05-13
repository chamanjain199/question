package leetcode.daily.challenge;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    int arr[] = new int[1000];
    int cursor = 0;

    public PeekingIterator(Iterator<Integer> iterator) {

        int index = 0;
        for (Iterator<Integer> it = iterator; it.hasNext(); ) {
            Integer i = it.next();
            arr[index++] = i;
        }


    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return arr[cursor];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return arr[cursor++];

    }

    @Override
    public boolean hasNext() {
        int temp = cursor;
        return arr[temp] != 0;
    }
}
