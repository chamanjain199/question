package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int first = intervals[i][0];
        int second = intervals[i][1];

        while (i < len) {
            if (intervals[i][0] <= second) {
                second = Math.max(second, intervals[i][1]);
            } else {
                result.add(new int[]{first, second});
                first = intervals[i][0];
                second = intervals[i][1];
            }
            i++;
        }
        result.add(new int[]{first, second});
        return result.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        int input[][] = new int[][]{{1, 4}, {0, 8}};
        int[][] ans = merge(input);
        System.out.println(Arrays.deepToString(ans));

    }
}
