package test;

public class CountHillAndValley {
    public static int countHillValley(int[] nums) {
        int totalHillValley = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length - 1; ) {
            int currentNum = nums[i];
            int next = nums[++i];
            while (next == currentNum && i < nums.length - 1) {
                next = nums[++i];
            }
            if (currentNum > pre && currentNum > next) {
                totalHillValley++;
            } else if (currentNum < pre && currentNum < next) {
                totalHillValley++;
            }
            pre = currentNum;
        }
        return totalHillValley;
    }

    public int countHillValley1(int[] nums) {
        int totalHillValley = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length - 1; ) {
            int currentNum = nums[i];
            while (nums[++i] == currentNum && i < nums.length - 1); //find next not equal element;
                                                                    // moving i it-self, so no nested loop.
            int next=nums[i];

            if (currentNum > pre && currentNum > next || currentNum < pre && currentNum < next) {
                totalHillValley++;
            }
            pre = currentNum; // now current element becomes pre
                              // we can not use nums[i-1] as pre because in case of equal element we need not equal pre but nums[i-1] will return equal
        }
        return totalHillValley;
    }


    public int countHillValley2(int[] nums) {
        int r = 0, left = nums[0];
        for (int i = 1; i < nums.length - 1; i++)
            if (left < nums[i] && nums[i] > nums[i + 1] || left > nums[i] && nums[i] < nums[i + 1]) {
                r++;
                left = nums[i];
            }
        return r;
    }

    public static void main(String[] args) {

        System.out.println(countHillValley(new int[]{57, 57, 57, 57, 57, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 85, 85, 85, 86, 86, 86}));
    }
}
