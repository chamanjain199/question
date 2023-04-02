package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        int[][] trains = new int[n][2];
        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }
        Arrays.sort(trains, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(trains[0][1]);

        for (int i = 1; i < n; i++) {
            int[] train = trains[i];
            if (train[0] > priorityQueue.peek()) {
                priorityQueue.poll();

            }
            priorityQueue.add(train[1]);

        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {

    }
}
