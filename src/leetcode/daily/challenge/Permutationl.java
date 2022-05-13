package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.List;

public class Permutationl {
    static List<List<Integer>> integerList = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int size=1;
        for (int i = 1; i <=nums.length; i++) {
            size*=i;
        }
        integerList=new ArrayList<>(size);
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


    public static void main(String[] args) {
        permuteUnique(new int[]{1, 2, 3});
    }
}
