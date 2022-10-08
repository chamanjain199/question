package geeksForGeeks.searching;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length==1){
            if(target==nums[0]){
              return 0;
            }else{
                return -1;
            }
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
          if (nums[mid] >= nums[low]) { //if num[mid==num[low] that means number was not in till mid so we need low= mid+1
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3}, 3));
    }
}
