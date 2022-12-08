package geeksForGeeks.searching;

public class MinimumNumberInASortedRotatedArray {


    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        if (nums[high] > nums[low]) {
            return nums[0];
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid + 1] < nums[mid]) {
                // moving left to right element always be in increasing order
                // if we find  any small element after any  element that is the rotation point
                // ex : 3,4,5,1,2
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                // moving right to left element always be in decreasing order
                // if we find  any bigger element before any  element that is the rotation point
                //ex : 4,5,1,2,3
                return nums[mid];
            }
            if (nums[high] < nums[mid]) {
                // if high is smaller than mid means left array is sorted and we will find our rotation point in right half
                // ex : 3,4,5,1,2
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];

    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        System.out.println(findMin(arr));

    }
}
