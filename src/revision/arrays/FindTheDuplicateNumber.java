package revision.arrays;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int index = nums[0];
        while (true) {
            if (nums[index] < 0) {  //index is actually the number which is again referring the same index again which it made negative in its first instance
                return index;
            } else {
                int temp = nums[index];
                nums[index] *= -1;
                index = temp;
            }
        }
    }

    public static int findDuplicate2(int[] nums) {
        // as question says there are number from 1 to n+1
        // now assume all number are on same index as number ex:  1 is at 1 index and 2 is at 2 index
        // but the number at 0 index where its go?
        // let assume arrays has number [1,2,3]
        // if we place 1 at 1 and 2 at 2 so 3 can now we placed at any place but
        // as question says there must be one number that is repeated so question would be [1,2,3,3] or [1,1,2,3] or [1,2,2,3]
        // now if we place each number on their own index
        // [0,1,2,3] now the remaining number a duplicate number


        int cur = nums[0];
        nums[0] = 0;
        while (cur != nums[cur]) {
            int temp = nums[cur];
            nums[cur] = cur;
            cur = temp;
        }
        return cur;
    }

    public static int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;


    }

    public static void main(String[] args) {
        int input[] = new int[]{1, 2, 3, 4, 5, 5};
        System.out.println(findDuplicate2(input));
    }
}