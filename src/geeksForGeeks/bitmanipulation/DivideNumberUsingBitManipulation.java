package geeksForGeeks.bitmanipulation;

public class DivideNumberUsingBitManipulation {
    public static int divide(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
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
        int i = 0;
        while (divisor1 <= dividend1) {
            i++;
            long shift = (divisor1) << i;
            if (shift > dividend1) {
                dividend1 = (dividend1 - (divisor1 << (i - 1)));
                ans += 1 << (i - 1);
                i = 0;
            } else if (shift == dividend1) {
                ans += 1 << i;
                break;
            }
        }
        return ans * sign;
    }

    public static int divide2(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
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
                dividend1 = dividend1 - (divisor1 << i);
                ans += 1 << i;
            }
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(divide2(-2147483648, 2));
    }
}
