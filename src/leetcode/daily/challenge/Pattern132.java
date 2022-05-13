package leetcode.daily.challenge;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class Pattern132 {

    public static boolean find132patternBF(int[] nums) {
        int one = 0;
        int three = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (one == nums[i]) {
                continue;
            }
            one = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {

                three = nums[j];
                if (three > one)
                    for (int k = j + 1; k < nums.length; k++) {
                        int two = nums[k];
                        if (two > one && two < three) {
                            return true;
                        }
                    }
            }
        }
        return false;

    }

    public static boolean find132pattern(int[] nums) {
        int min = nums[0];

        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] > min && nums[j] < nums[k]) {
                    return true;
                }
                min = Math.min(min, nums[j]);
            }
        }

        return false;

    }


//    public static boolean find132pattern1(int[] nums) {
//        Stack<Integer> st = new Stack<>();
//        int thirdElement = Integer.MIN_VALUE;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] < thirdElement) return true;
//            while (!st.isEmpty() && st.peek() < nums[i]) thirdElement = st.pop();
//            st.push(nums[i]);
//        }
//        return false;
//    }

    public static void main(String[] args) {
        //1,3,2,4,5,6,7,8,9,10  //true
        //-2 ,1 ,1 ,-2 ,1 ,1  //false
        //3,5,0,3,4  //true
        System.out.println(find132patternBF(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
    }
}
