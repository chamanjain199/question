package leetcode.daily.challenge;

import java.util.*;

public class Permutationll {
    static List<List<Integer>> integerList = new ArrayList<>();
    static BitSet bs = new BitSet();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int size = 1;
        for (int i = 1; i <= nums.length; i++) {
            size *= i;
        }
        Arrays.sort(nums);
        integerList = new ArrayList<>(size);
        List<Integer> integerList1 = new ArrayList<>(nums.length);
        recustion(nums, integerList1);

        return integerList;
    }

    private static void recustion(int nums[], List<Integer> list) {
        if (list.size() == nums.length) {
            System.out.println(list);
            integerList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (bs.get(i)) {
                continue;
            }
            if(i>0 && !bs.get(i-1) && nums[i]==nums[i-1]){
                //bs.get(i-1) if previous bit iteration is set means this iteration comes as part of previous value
                //!bs.get(i-1) if previous bit iteration is not set means this iteration is new for same repeat value hence can be ignore

                continue;
            }

            bs.set(i);
            list.add(nums[i]);
            recustion(nums, list);
            list.remove(list.size() - 1);
            bs.set(i, false);
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
            if (bs.get(i)) {
                continue;
            }
            if(i>0 && !bs.get(i-1) && nums[i]==nums[i-1]){
                continue;
            }
            swap(level, i, nums);
            permutationRecSwap(nums, level + 1);
            swap(level, i, nums);
            bs.set(i, false);
        }
    }
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        permuteUnique(new int[]{5,4,5});
        System.out.println(integerList.size());
        HashSet<List<Integer>> hs=new HashSet<>(integerList);
        System.out.println(hs.size());

    }
}
