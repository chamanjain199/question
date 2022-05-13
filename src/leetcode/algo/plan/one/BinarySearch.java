package leetcode.algo.plan.one;

public class BinarySearch {
    public int searchWithWhile(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int midEle;
        while ( start<=end) {
            mid = (start + end) / 2;
            midEle = nums[mid];
            if (target == midEle) {
                return mid;
            } else if (target < midEle) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public int searchWithFor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int midEle;
        for ( ;start<=end;) {
            mid = (start + end) / 2;
            midEle = nums[mid];
            if (target == midEle) {
                return mid;
            } else if (target < midEle) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.searchWithWhile(new int[]{-1}, -1));


    }
}
