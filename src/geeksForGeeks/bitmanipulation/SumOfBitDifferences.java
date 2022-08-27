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

    public static void main(String[] args) {
        System.out.println(sumBitDifferences(new int[]{1, 2}, 2));
    }
}
