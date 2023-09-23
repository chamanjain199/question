package revision.arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length;
        while (mid < high) {
            switch (nums[mid]) {
                case 0 -> swap(nums, low++, mid++);
                case 2 -> swap(nums, mid, --high);
                case 1 -> mid++;
            }
        }
    }

    static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
