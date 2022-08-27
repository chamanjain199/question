package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UU {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }
    public void helper(int idx, int[] nums, List<Integer> list){


        res.add(new ArrayList<>(list));

        for(int i=idx;i<nums.length;i++){
          //  if(i!=idx && nums[i]==nums[i-1])continue;
            list.add(nums[i]);
            helper(i+1, nums, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        UU uu=new UU();
        System.out.println(uu.subsetsWithDup(new int[]{1,2,3}));
    }
}