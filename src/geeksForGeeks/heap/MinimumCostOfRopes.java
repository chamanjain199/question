package geeksForGeeks.heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    long minCost(long arr[], int n)
    {
        long cost=0;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>1){
            long temp=pq.poll()+pq.poll();
            pq.add(temp);
            cost+=temp;
        }

        return cost;
    }
}
