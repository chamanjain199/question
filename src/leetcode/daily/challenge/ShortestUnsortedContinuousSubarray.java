package leetcode.daily.challenge;

public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 2;
            } else return 0;
        }

        int start = 0;
        int end = 0;
        boolean startDec=false;
        boolean endDec=false;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {

            if (nums[i] > nums[i + 1] && !startDec) {
                startDec=true;
                start = i;
            }
            if ((nums[j - 1] > nums[j] || (startDec && nums[j - 1] > nums[j])) && !endDec) {
                endDec=true;
                end = j;
            }
        }
        if(start==0 && end==0){
            return 0;
        }

        return end - start+1;


    }

    public static void main(String[] args) {

        System.out.println(findUnsortedSubarray(new int[]{5,4,3,2,1}));
    }
}
