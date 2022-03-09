package leetcode.top100.liked;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
       int otherCounter=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[otherCounter] != nums[i]) {
                nums[++otherCounter]=nums[i];
            }
        }
        return otherCounter+1;

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int i = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {


        List<int[]> l = List.of(new int[]{1, 1, 1},new int[]{1, 2, 3}, new int[]{-3, -3, -2, -1, -1, 0, 0, 0, 0, 0}, new int[]{1, 1, 2}, new int[]{1, 2, 2}, new int[]{1, 2}, new int[]{1, 2, 2, 3});

        for (int i = 0; i < l.size(); i++) {
            System.out.println(removeDuplicates1(l.get(i)));
            System.out.println(Arrays.toString(l.get(i)));
        }

    }
}
