package leetcode.top100.liked;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroesWorst(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int k = i;
                while (k < j) {
                    nums[k] = nums[k + 1];
                    k++;
                }
                nums[k] = 0;
                j = k;
            }

        }
        System.out.println(Arrays.toString(nums));


    }

    public static void moveZeroes(int[] nums) {
        int nonZoroShoudBeAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[nonZoroShoudBeAt++] = nums[i];
        }
        while (nonZoroShoudBeAt< nums.length){
            nums[nonZoroShoudBeAt++]=0;
        }
    }
    public void moveZeroesBest(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                if (idx < i)
                    nums[i] = 0;
                ++idx;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{1, 1, 0, 2});
        System.out.println();
    }
}
