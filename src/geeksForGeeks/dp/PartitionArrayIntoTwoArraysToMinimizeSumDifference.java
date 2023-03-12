package geeksForGeeks.dp;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static int minimumDifference(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        boolean[] prev = new boolean[total + 1];
        boolean[] cur;
        prev[0] = true;
        prev[arr[0]] = true;
        for (int i = 1; i < n; i++) {
            cur = new boolean[total + 1];
            cur[0] = true;
            for (int j = 0; j <= total; j++) {
                boolean notSelect = prev[j];
                boolean select = false;
                if (j >= arr[i]) {
                    select = prev[j - arr[i]];
                }
                cur[j] = notSelect || select;
            }
            prev = cur;
        }

        int half = total / 2;
        if ((total ^ 1) == 1) {
            half = half + 1;
        }

        for (int i = half; i >= 0; i--) {
            if (prev[i]) {
                return ((total - i) - i);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{36, 36}));
    }
}
