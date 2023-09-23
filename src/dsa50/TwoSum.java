package dsa50;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum  {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            Integer other = map.get(target - nums[i]);
            if (other != null && other != i) {
                return new int[]{i, other};
            }
        }
        return null;
    }

    //MLE
    public int[] twoSum3(int[] nums, int target) {
        int len = nums.length;
        int[][] nums2 = new int[len][len];
        for (int i = 0; i < len; i++) {
            nums2[i]= new int[]{nums[i],i};
        }
        Arrays.sort(nums2, Comparator.comparingInt(x -> x[0]));
        int first = 0;
        int last = len - 1;
        int sum;
        while (first < last) {
            sum = nums2[first][0] + nums2[last][0];
            if (sum == target) {
                return new int[]{nums2[first][1], nums2[last][1]};
            } else if (sum < target) {
                first++;
            } else {
                last--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum.twoSum3(input, 6)));

    }
}
