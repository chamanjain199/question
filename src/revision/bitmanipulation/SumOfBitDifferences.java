package revision.bitmanipulation;

public class SumOfBitDifferences {
    static long sumBitDifferences(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int countOn = 0;
            for (int num : arr) {
                if ((1 & (num >> i)) == 1) {
                    countOn++;
                }
            }
            int countOff = n - countOn;
            ans += countOff * countOn;
        }
        return ans * 2L;
    }

    public static void main(String[] args) {
        System.out.println(sumBitDifferences(new int[]{1, 2}, 2));
    }
}
