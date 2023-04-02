package revision.bitmanipulation;

public class MaximumANDValue {
    public static int maxAND(int arr[], int N) {

        int pattern = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            int mask =pattern| (1 << i);
            for (int j = 0; j < N; j++) {
                if ((arr[j] & mask) ==mask) {
                    count++;
                }
                if (count == 2) {
                    break;
                }
            }
            if (count == 2) {
                pattern = pattern | mask;
            }

        }
        return pattern;
    }
}
