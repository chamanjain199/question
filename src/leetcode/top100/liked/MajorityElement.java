package leetcode.top100.liked;

public class MajorityElement {

    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static int majorityElement(int[] nums) {

        int count = 1;
        int majorityElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
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
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            System.out.println("Majroty eleemt " + majorityElement);
        }
        return majorityElement;

    }

    public static void main(String[] args) {

    }
}
