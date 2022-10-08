package geeksForGeeks.searching;

public class FindThePickElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int low = 1;
        int high = nums.length - 2;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid - 1] >= nums[mid]) {
                high = mid - 1;
            } else if (nums[mid + 1] >= nums[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
