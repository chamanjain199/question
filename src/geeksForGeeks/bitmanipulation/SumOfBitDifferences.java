package geeksForGeeks.bitmanipulation;

public class SumOfBitDifferences {
    static long sumBitDifferences(int[] arr, int n) {
        long result = 0;
        for (int i = 0; i <= 31; i++) {
            long count = 0;
            for (int num : arr) {
                count += (num >> i) & 1;
            }
            result += count * (n - count);
        }
        return result * 2;
    }
    static int mod=1000000007;
    static int countBits(int N, long A[])
    {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long countOn = 0;
            long mask=(1<<i);
            for (long num : A) {
                if ((mask&num)>0) {
                    countOn++;
                }
            }
            long countOff = N - countOn;
            ans = (ans+(countOff * countOn)%mod)%mod;
        }
        return (int)(ans * 2)%mod;
    }

    public static void main(String[] args) {
        System.out.println(sumBitDifferences(new int[]{1, 2}, 2));
    }
}
