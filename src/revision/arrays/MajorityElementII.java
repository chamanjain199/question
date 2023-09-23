package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 = -1;
        int c1 = 0;
        int c2 = 0;
        int len = nums.length;
        for (int num : nums) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        int one3Majority = len / 3;
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            }
        }
        List<Integer> ans = new ArrayList<>(2);
        if (c1 > one3Majority) {
            ans.add(num1);
        }
        if (c2 > one3Majority) {
            ans.add(num2);
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
