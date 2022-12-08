package geeksForGeeks.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
   static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i <=k; i++) {
            pq.offer(arr[i]);
        }
        while (i < num) {
            ans.add(pq.poll());
            pq.add(arr[i]);
            i++;
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(nearlySorted(new int[]{6,5,3,2,8,10,9},7,3));
    }
}
