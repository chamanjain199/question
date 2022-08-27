package leetcode.daily.challenge;

public class NonDecreasingArray {
    public static boolean checkPossibility0(int[] nums) {
        int modification = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] > nums[i]) {
                if (++modification > 1) {
                    return false;
                }
                if (index > 0 && nums[index - 1] > nums[i]) {
                    continue;
                }
            }
            index = i;
        }
        return true;
    }

    public boolean checkPossibilityCopied(int[] nums) {
        int modified = 0, prev = nums[0], index = 0;
        for (; index < nums.length; ++index) {
            if (nums[index] < prev) {
                if (++modified > 1) return false;
                if (index - 2 >= 0 && nums[index - 2] > nums[index]) continue;
            }
            prev = nums[index];
        }
        return true;
    }

    public static boolean checkPossibility2(int[] nums) {

        int modification = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] > nums[i]) {
                if (++modification > 1) {
                    return false;
                }
                if (index > 0 && nums[index - 1] <= nums[i]) {  // skip index in case   2,5,3,4 ex : skip 5 and compare 3 and 4 next time
                    // keep index in case   5,7,1,8 ex : skip 1 and keep 7 and compare 7 and 8 next time
                    index++;
                } else if (index == 0) {
                    index++;
                }
            } else index = i;
        }
        return true;
    }

    public static void main(String[] args) {
        //                                            5,7,1,8 t
        //                                            3,4,2,3 f
        //4,2,3 t
        //2,6,4,8,10,9,15 f
        //[1,5,4,6,7,10,8,9] f
        //[1,4,1,2] t
        //2,3,1,5,4 f
        System.out.println(checkPossibility0(new int[]{3, 4, 2, 3}));
    }
}
