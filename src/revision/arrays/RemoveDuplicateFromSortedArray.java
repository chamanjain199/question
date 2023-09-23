package revision.arrays;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static  int removeDuplicates(int[] nums) {
        int len = nums.length;
        int lastNonDuplicateNumberIndex = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++lastNonDuplicateNumberIndex] = nums[i];
            }
        }
        return lastNonDuplicateNumberIndex+1;
    }
    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        int lastNonDuplicateNumberIndex = 0;
        int count=1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1] ) {
                nums[++lastNonDuplicateNumberIndex] = nums[i];
                count=1;
            }else if(count<2){
                count++;
                nums[++lastNonDuplicateNumberIndex] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));

        return lastNonDuplicateNumberIndex+1;
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates2(new int[]{0,0,1,1,1,1,2,3,3}));

    }
}
