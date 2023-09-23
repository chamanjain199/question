package revision.recustion;


public class FindDuplicate {
    public static int findDuplicate(int[] nums) {

        return store(nums, 0);

    }

    private static int store(int[] nums, int cur) {
        if (nums[cur] == cur) {
            return cur;
        }
        int ncur = nums[cur];
        nums[cur] = cur;
        return store(nums, ncur);
    }

    public static void main(String[] args) {

    }
}
