package dsa50;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
    public void containsDuplicate(List<? extends Integer> list)  {
       list.add(0);
    }

    public boolean containsDuplicate2(int[] nums) {
        int len = nums.length;
        int[] other = new int[len];
        for (int num : nums) {
            if (other[num] != 0) return true;
            else {
                other[num] = num;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(4);
        System.out.println(test(inputs));

    }
}
