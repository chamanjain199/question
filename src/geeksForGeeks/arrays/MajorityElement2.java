package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 =  -1;
        int c1 = 0;
        int c2 = 0;
        int len = nums.length;
        for (int j : nums) {
            if (j == num1) {
                c1++;
            } else if (j == num2) {
                c2++;
            } else if ( c1 == 0) {
                num1 = j;
                c1 = 1;
            } else if ( c2 == 0) {
                num2 = j;
                c2= 1;
            } else {
                c1--;
                c2--;
            }
        }
        int one3Majority = len / 3;
        c1 = 0;
        c2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            }

        }
        if (c1 > one3Majority) {
            ans.add(num1);
        }
        if (c2 > one3Majority) {
            ans.add(num2);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,4,5,6,7,8,9}));

    }
}
