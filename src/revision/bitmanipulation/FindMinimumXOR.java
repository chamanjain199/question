package revision.bitmanipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMinimumXOR {
    public int findMinimumXOR(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int xor = (nums[i - 1] ^ nums[i]);
            min = Math.min(xor, min);
        }
        return min;
    }
}
