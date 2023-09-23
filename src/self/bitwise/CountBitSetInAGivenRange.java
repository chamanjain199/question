package self.bitwise;

public class CountBitSetInAGivenRange {
    static int countBits(int N) {
        if (N <= 0) {
            return 0;
        }
        int lbo2 = lbo2(N);
        int count = (1 << (lbo2 - 1)) * lbo2;
        int remaining = N - (1 << lbo2);
        count += remaining + 1;
        count += countBits(remaining);
        return count;

    }

    private static int lbo2(int number) {
        return (int) (Math.log(number) / Math.log(2));
    }
}
