package geeksForGeeks.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {
    public static int[][] overlappedInterval(int[][] Intervals) {
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int start = Intervals[0][0];
        int end = Intervals[0][1];
        for (int i = 1; i < Intervals.length; i++) {
            if (end >= Intervals[i][0]) {
                end = Math.max(end, Intervals[i][1]);
            } else {

                list.add(new int[]{start, end});
                start = Intervals[i][0];
                end = Intervals[i][1];
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(overlappedInterval(new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}})));
    }
}
