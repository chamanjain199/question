package revision.arrays;

import geeksForGeeks.arrays.MajorityElement2;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == majorityElement) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorityElement = nums[i];
                    count = 1;
                }
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement(new int[]{3, 2, 3}));
    }
}
