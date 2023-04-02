package geeksForGeeks.bitmanipulation;

import java.util.Arrays;

public class FindMinimumXOR {
    public int findMinimumXOR(int[] nums) {

        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <nums.length ; i++) {
            int xor=(nums[i]^nums[i-1]);
            if(xor<min){
                min=xor;
            }
        }
        return min;

    }
}
