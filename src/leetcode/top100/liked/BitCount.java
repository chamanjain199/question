package leetcode.top100.liked;

import java.util.Arrays;

//https://leetcode.com/problems/counting-bits/discuss/1892931/99.97-Faster-or-Linear-Time-complexity-or-Easy-solution
public class BitCount {
    public static int[] countBits(int n) {
        int ans[] = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int temp = i & (i - 1);
            System.out.println(i + "  " + (i - 1) + "  " + temp + "  " + ans[temp] + " " + Arrays.toString(ans));
            ans[i] = ans[temp] + 1;
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(countBits(100));

    }
}
