package leetcode.top100.liked;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> haset=new HashSet<>(nums.length);
        for(int i=0;i<nums.length;i++){
           if(!haset.add(nums[i])){
               return true;
           }
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
