package revision.bitmanipulation;

public class LongestConsecutive {
    public static int maxConsecutiveOnes(int N) {

        int count = 0;
        int maxCount = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }

            N = N >> 1;
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;

    }

    public static void main(String[] args) {

    }
}
