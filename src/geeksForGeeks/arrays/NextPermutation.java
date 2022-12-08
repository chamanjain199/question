package geeksForGeeks.arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int firstLowerIndex = nums.length - 2;
        int toReplace = nums.length - 1;

        while (firstLowerIndex >= 0 && nums[firstLowerIndex] >= nums[firstLowerIndex + 1]) firstLowerIndex--;

        if (firstLowerIndex >= 0) {
            while (nums[toReplace] <= nums[firstLowerIndex]) toReplace--;
            swap(firstLowerIndex,toReplace,nums);
        }
        reverse(firstLowerIndex+1,nums.length-1,nums);
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int i, int j, int[] nums) {
        while (i < j) swap(i++, j--, nums);
    }

    public static void main(String[] args) {

    }
}
