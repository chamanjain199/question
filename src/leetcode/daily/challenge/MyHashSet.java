package leetcode.daily.challenge;

import java.util.BitSet;

public class MyHashSet {
    BitSet mybitset;

    public MyHashSet() {
        mybitset = new BitSet(100);
    }
    private int hash(int key){
        return key%100;
    }

    public void add(int key) {
        mybitset.set(hash(key));
    }

    public void remove(int key) {
        mybitset.set(hash(key), false);
    }

    public boolean contains(int key) {
       return mybitset.get(hash(key));
    }
}
