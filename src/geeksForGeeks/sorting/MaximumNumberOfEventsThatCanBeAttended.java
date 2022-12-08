package geeksForGeeks.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int[] next = new int[events[events.length - 1][1] + 2];
        int count = 0;
        int lastNotFill = 1;

        for (int i = 0; i < events.length; i++) {
            int start = Math.max(events[i][0], lastNotFill);
            int end = events[i][1];
            for (int j = start; j <= end; j++) {
                if (next[j] == 0) {
                    if (j == lastNotFill) {
                        lastNotFill++;
                    }
                    count++;
                    next[j] = 1;
                    break;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
    }
}
