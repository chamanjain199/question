package geeksForGeeks.arrays;

public class LongestTurbulentSubarray {
    //consecutive even odd
    public static int maxTurbulenceSize(int[] arr) {
        boolean isPreEleEven = (arr[0] & 1) == 0;
        int len = arr.length;
        int count = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            boolean isCurrentEven = (arr[i] & 1) == 0;
            if (isPreEleEven != isCurrentEven) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
            isPreEleEven=isCurrentEven;
        }
        return max;
    }
    public static int maxEvenOdd2(int arr[], int n) {
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
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }
}
