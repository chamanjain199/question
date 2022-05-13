package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class FlattenNestedListIterator implements Iterator<Integer> {


    List<Integer> intlist = new ArrayList<>();
    int index = 0;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {

        addAll(nestedList);
    }

    private void addAll(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty()) {
            return;
        }
        for (NestedInteger nestedInteger :
                nestedList) {

            if (nestedInteger.isInteger()) {
                intlist.add(nestedInteger.getInteger());
            }
            addAll(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        return intlist.get(index++);

    }

    @Override
    public boolean hasNext() {

        return intlist.isEmpty();

    }
}

