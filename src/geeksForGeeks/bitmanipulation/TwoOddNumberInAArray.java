package geeksForGeeks.bitmanipulation;

import java.util.Arrays;

public class TwoOddNumberInAArray {
    public static int[] twoOddNum(int nums[]) {
        int xor = 0;
        int res1 = 0;
        int res2 = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int rightmostbitset = xor & (-xor);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & (rightmostbitset)) != 0) {
                res1 ^= nums[i];
            } else {
                res2 ^= nums[i];
            }
        }

        return new int[]{res1, res2};
    }

    public static int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }

        return new int[]{x, bitmask ^ x};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoOddNum(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 6, 6})));

    }
}
