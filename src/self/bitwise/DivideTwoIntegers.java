package self.bitwise;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0 ^ divisor > 0) ? -1 : 1;
        long unDividend = Math.abs(dividend);
        long unDivisor = Math.abs(divisor);
        if (unDividend == unDivisor) {
            return sign;
        }
        if (unDivisor == 1) {
            return (int) unDividend * sign;
        }

        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if ((unDivisor << i) <= unDividend) {
                unDividend = unDividend - (unDivisor << i);
                ans += (1 << i);
            }
        }
        return ans * sign;


    }
}
