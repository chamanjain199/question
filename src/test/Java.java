package test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Java {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> ab = new ArrayBlockingQueue<>(2);
         ConcurrentHashMap chm=new ConcurrentHashMap<>(6,8,9);
         ClassLoader cp=Java.class.getClassLoader();
        ab.offer(1);
        ab.offer(2);
        System.out.println("hello 1");
        BitSet set=new BitSet();
        set.set(23);
        HashMap hm=new HashMap();
        hm.remove("Ff");

        ab.put(3);
        System.out.println("hello 2");
        System.out.println(ab);
    }
}
