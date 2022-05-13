package leetcode.daily.challenge;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int find=k-nums[i];
            Integer found=map.get(find);
            if(found==null){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }else{
                count++;
               if(found==1){
                   map.remove(find);
               }else{
                   map.put(find,found-1);
               }
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
