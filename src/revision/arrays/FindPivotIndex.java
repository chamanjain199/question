package revision.arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (leftSum == total) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
