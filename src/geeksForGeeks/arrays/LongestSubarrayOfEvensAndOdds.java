package geeksForGeeks.arrays;

public class LongestSubarrayOfEvensAndOdds {
    public static int maxEvenOdd(int arr[], int n) {
        int maxAns = 0;
        boolean isPreEven = (arr[0] & 1) == 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            boolean isCurrentEven = (arr[i] & 1) == 0;
            if (isPreEven == isCurrentEven) {
                maxAns = Math.max(count, maxAns);
                count = 0;
            }
            isPreEven = isCurrentEven;
            count++;
        }
        maxAns = Math.max(count, maxAns);
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(maxEvenOdd(new int[]{10, 12, 14, 7, 8}, 5));
    }
}
