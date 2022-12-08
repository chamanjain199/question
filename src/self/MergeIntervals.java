package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < len; i++) {
            while (i < len && end > intervals[i][0]) {
                end = intervals[i][1];
                i++;
            }
            ans.add(new int[]{start, end});
            start = intervals[i][0];
            end = intervals[i][1];
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][0]);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
