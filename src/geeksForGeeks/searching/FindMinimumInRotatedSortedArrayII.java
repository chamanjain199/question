package geeksForGeeks.searching;

public class FindMinimumInRotatedSortedArrayII {
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
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else if(nums[mid]<nums[high]){
                high=mid;
            }else{
                high--;
            }
        }
        return nums[low];


    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(findMin(arr));
    }
}
