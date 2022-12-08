package geeksForGeeks.arrays;

public class FindTheDuplicateNumber {
    public static int findDuplicate1(int[] nums) {
        int len = nums.length;
        int traverse = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[traverse] < 0) {
                return traverse;
            } else {
                int temp = traverse;
                traverse = nums[traverse];
                nums[temp] = -1;
            }
        }
        return -1;
    }

    public static int findDuplicatePigeonhole(int[] nums) {
        int cur = 0;
        while (cur != nums[cur]) {
           int next=nums[cur];
           nums[cur]=cur;
           cur=next;
        }
        return cur;
    }

    public static int findDuplicateWithoutModifingArray(int[] nums) {
        int slow = nums[0];
        int  faste = nums[0];
        do {
            slow = nums[slow];
            faste = nums[nums[faste]];
        } while (nums[slow] != nums[faste]);
        faste = nums[0];
        while (slow != faste) {
            slow = nums[slow];
            faste = nums[faste];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePigeonhole(new int[]{1,1,2}));
    }
}
