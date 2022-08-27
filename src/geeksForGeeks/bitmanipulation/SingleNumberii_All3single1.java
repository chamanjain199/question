package geeksForGeeks.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumberii_All3single1 {
    public int singleNumberSol1(int[] nums) {
        HashMap<Integer, Integer> mapping = new HashMap<>((nums.length / 3) + 1);
        for (int i = 0; i < nums.length; i++) {

            mapping.put(nums[i], mapping.getOrDefault(nums[i], 0) + 1);
        }
        return mapping.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
    }

    public static int singleNumberSolOptimized1(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length; i += 3) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return 0;
    }

    public int singleNumberSolOptimized2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int numOfOnce = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    numOfOnce++;
                }
            }
            if (numOfOnce % 3 != 0) {
                ans |= mask;
            }
        }
        return ans;
    }



    public static int singleNumberSolOptimized3(int[] nums) {

        int cwn = ~0; //all 1
        int cwn1 = 0;
        int cwn2 = 0;

        for (int num : nums) {
            int commonWithcwn = cwn & num;
            int commonWithcwn1 = cwn1 & num;
            int commonWithcwn2 = cwn2 & num;

            cwn = cwn & (~commonWithcwn);
            cwn1 = cwn1 | commonWithcwn;

            cwn1 = cwn1 & (~commonWithcwn1);
            cwn2 = cwn2 | commonWithcwn1;

            cwn2 = cwn2 & (~commonWithcwn2);
            cwn = cwn | commonWithcwn2;

        }
        return cwn1;
    }

//1. adding "val" to the "set" if "val" is not in the "set" => A^0 = A
//2. removing "val" from the "set" if "val" is already in the "set" => A^A = 0
//    Beautiful. Let me describe it to see if I'm understanding it right:
//    First time number appear -> save it in "ones"
//    Second time -> clear "ones" but save it in "twos" for later check
//    Third time -> try to save in "ones" but value saved in "twos" clear it.

    public int singleNumberSolOptimized4(int[] input) {
        int seenOnce = 0, seenTwice = 0;
        for (int num : input) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

    public static void main(String[] args) {

        System.out.println(singleNumberSolOptimized3(new int[]{30000, 500, 100, 30000, 100, 30000, 100}));

    }
}
