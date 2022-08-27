package leetcode.biweekly.contest;

import java.util.HashMap;
import java.util.HashSet;

public class ReplaceElInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i++) {
            int num1 = operations[i][0];
            int num2 = operations[i][1];
            int index = hashMap.get(num1);
            nums[index] = num2;
            hashMap.remove(num1);
            hashMap.put(num2, index);
        }
        return nums;

    }

    public static void main(String[] args) {

    }
}
