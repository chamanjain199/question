package revision.bitmanipulation;

public class Divide {
    public int divide(int dividend, int divisor) {
        int sign = dividend == divisor ? 1 : -1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        if (dividend1 == divisor1) {
            return sign;
        }
        if (divisor1 == 1) {
            return (int) (sign * dividend1);
        }

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((divisor1 << i) <= dividend1) {
                dividend1 -= divisor1 << 1;
                ans += i;
            }
        }
        return ans * sign;
    }

    public static void main(String[] args) {

    }
}
