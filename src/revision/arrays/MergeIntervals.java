package revision.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] overlappedInterval(int[][] Intervals) {
        Arrays.sort(Intervals, Comparator.comparingInt(x -> x[0]));
        int start = Intervals[0][0];
        int end = Intervals[0][1];
        int len = Intervals.length;
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (end >= Intervals[i][0]) {
                end = Math.max(end, Intervals[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = Intervals[i][0];
                end = Intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
