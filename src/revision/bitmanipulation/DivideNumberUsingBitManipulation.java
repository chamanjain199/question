package revision.bitmanipulation;

public class DivideNumberUsingBitManipulation {
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        if (dividend1 == 1 && divisor1 == 1) {
            return sign;
        }
        if (divisor1 == 1) {
            return (int) (dividend1 * sign);
        }
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((divisor1 << i) <= dividend1) {
                dividend1 -= divisor1 << i;
                ans += 1 << i;
            }
        }
        return ans * sign;

    }
}
