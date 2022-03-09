package leetcode.top100.liked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int mapsays=map.getOrDefault(target-nums[i],-1);
            if (mapsays!=-1 && mapsays!=i){
                return new int[]{i,mapsays};
            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
    }
}
