package revision.bitmanipulation;

public class CountBitSetInAGivenRange {
    static int countBits(int N) {
        if (N <= 0) {
            return 0;
        }
        int count = 0;
        int lpo2 = largestPowerOf2InRange(N);
        count += (1 << (lpo2 - 1)) * lpo2;
        int remaining = N - (1 << (lpo2));
        count += remaining + 1;
        count += countBits(remaining);
        return count;
    }

    static int largestPowerOf2InRange(int number) {
        double d = Math.log(number) / Math.log(2);
        return (int) d;
    }
}
