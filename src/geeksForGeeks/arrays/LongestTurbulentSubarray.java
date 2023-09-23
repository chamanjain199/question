package geeksForGeeks.arrays;

public class LongestTurbulentSubarray {
    //consecutive even odd
    public static int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        if (arr.length == 1) {
            return 1;
        }
        Boolean previousSign = null;
        int i = 1;
        previousSign = arr[i] == arr[i - 1] ? null : arr[i - 1] < arr[i];
        while (i<n && arr[i] == arr[i - 1]) {
            i++;
        }
        int len = arr.length;
        int count = 1;
        int max = 1;
        i++;
        Boolean currentSign = null;
        for (; i < len; i++) {
            currentSign = arr[i] == arr[i - 1] ? null : arr[i - 1] < arr[i];
            System.out.println("PAIR " + arr[i - 1] + " " + arr[i]);
            if (previousSign == null || currentSign == null || previousSign == currentSign) {
                count++;
                max = Math.max(count, max);
                count = 1;
            } else {
                count++;
            }
            previousSign = currentSign;
        }
        if (previousSign != null && currentSign != null)
            count++;
        max = Math.max(count, max);
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
        //0,8,45,88,48,68,28,55,17,24
        //0, 1, 1, 0, 1, 0, 1, 1, 0, 0
        //37,199,60,296,257,248,115,31,273,176
        System.out.println(maxTurbulenceSize(new int[]{9, 9, 9, 9}));
    }
}
