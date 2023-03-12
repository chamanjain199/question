package geeksForGeeks.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FrogJumpCodingNinjas {
    static int[] arr;

    public static int frogJump(int n, int heights[]) {
        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return frogJumpTopDown(n - 1, heights);
    }

    public static int frogJumpTopDown(int n, int heights[]) {
        if (n == 0) {
            return 0;
        }
        if (arr[n] != -1) {
            return arr[n];
        }

        int left = frogJumpTopDown(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = frogJumpTopDown(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return arr[n] = Math.min(left, right);
    }

    public static int frogJumpBottomUp(int n, int[] heights) {
        arr = new int[n + 1];
        for (int i = 1; i < n; i++) {

            int left = arr[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = arr[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            arr[i] = Math.min(left, right);
        }
        return arr[n - 1];
    }

    public static int frogJumpSpaceOptimized(int n, int[] heights) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int cur = Math.min(left, right);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

}
