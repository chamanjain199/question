package revision.arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int r = Math.min(m, n) - 1;
        double ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (double) (total - i) / (i + 1);

        }
        return (int)ans;
    }
}
