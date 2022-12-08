package geeksForGeeks.sorting;

import java.util.ArrayList;

public class ChocolateDistributionProblem {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        a.sort(null);
        int minDiff = Integer.MAX_VALUE;
        for (int i = m; i < n; i++) {
            minDiff = Math.min(a.get(i) - a.get(i - m), minDiff);
        }
        return minDiff;
    }
}
