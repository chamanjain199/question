package leetcode.top100.liked;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    public static int singleNumberOld(int[] nums) {
        Map<Integer,Integer> maps=new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer num=maps.get(nums[i]);
            if(num!=null){
                maps.put(nums[i],num+1);
            }else{
                maps.put(nums[i],1);
            }
        }
       return maps.keySet().iterator().next();
    }
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i =0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
