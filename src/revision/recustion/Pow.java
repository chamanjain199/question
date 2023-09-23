package revision.recustion;

public class Pow {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) {
            nn = -( nn);
        }
        while (nn > 0) {
            if ((nn & 1) == 0) {
                nn = nn >> 1;
                x = x * x;
            } else {
                nn=nn-1;
                ans *= x;
            }
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}
