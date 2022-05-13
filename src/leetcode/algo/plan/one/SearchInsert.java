package leetcode.algo.plan.one;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid-1 ;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right+1);

        // we will not return mid because we found that element at mid index is less than target
        // we can also return right+1; because of this if(left <= right) we will reach to missing element
        // when right will be less than left or equal
        return left;
    }

    public static void main(String[] args) {

        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 4));

    }
}
