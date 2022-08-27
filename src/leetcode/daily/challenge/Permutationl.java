package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutationl {
    static List<List<Integer>> integerList = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int size = 1;
        for (int i = 1; i <= nums.length; i++) {
            size *= i;
        }
        integerList = new ArrayList<>(size);
        List<Integer> integerList1 = new ArrayList<>(nums.length);

        recustion(nums, integerList1);
        System.out.println(integerList);
        return integerList;
    }

    private static void recustion(int nums[], List<Integer> list) {
        if (list.size() == nums.length) {
            integerList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                recustion(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void permutationRecSwap(int[] nums, int level) {
        if (level == nums.length - 1) {
            List<Integer> temp = new ArrayList();
            for (int i = 0; i < nums.length; i++)
                temp.add(nums[i]);
            integerList.add(temp);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(level, i, nums);
            permutationRecSwap(nums, level + 1);
            swap(level, i, nums);
        }
    }
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }





    public static void main(String[] args) {
        permuteUnique(new int[]{1, 2, 1});
        System.out.println(integerList);
    }
}
