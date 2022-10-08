package geeksForGeeks.searching;

public class AllocateMinimumNumberOfPages {
    public static int findPages(int[] A, int M) {
        int N = A.length;
        if (N == 1) {
            return A[0];
        }
        if (M > N) {
            return -1;
        }
        if (M == 1) {
            return sum(A, 0, A.length - 1);
        }
        return findOptimalPages(A, M, 0);

    }

    private static int findOptimalPages(int[] arr, int k, int index) {

        if (k == 1) {
            return sum(arr, index, arr.length - 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = index; i <= (arr.length - k); i++) {
            ans = Math.min(ans, Math.max(sum(arr, index, i), findOptimalPages(arr, k - 1, i + 1)));
        }

        return ans;

    }

    private static int sum(int[] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int findPagesOptimal(int[] A, int M) {
        int N = A.length;
        int total = A[0];
        int max = A[0];
        for (int i = 1; i < N; i++) {
            total += A[i];
            max = Math.max(max, A[i]);
        }
        int low = max;
        int high = total;
        int mid;
        int res = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isFeasible(A, mid, M)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;

    }

    private static boolean isFeasible(int[] a, int ans, int m) {
        int tempSum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if ((tempSum + a[i]) > ans) {
                count++;
                tempSum = a[i];
            } else tempSum += a[i];
        }
        if (tempSum < ans) {
            count++;
        }
        return count <= m;
    }

    public static void main(String[] args) {
        System.out.println(findPagesOptimal(new int[]{15, 10, 19, 10, 5, 18, 7}, 5));
    }
}
