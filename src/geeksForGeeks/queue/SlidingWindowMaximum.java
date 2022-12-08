package geeksForGeeks.queue;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length ;

        int[] ans = new int[len - k + 1];
        int curIndex = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        while (i < k) {
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.add(i);
            i++;
        }
        ans[curIndex++] = nums[list.getFirst()];
        for (int j = k, l = 1; j < len; j++, l++) {
            while (!list.isEmpty() && list.getFirst() < l) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[list.getLast()] < nums[j]) {
                list.removeLast();
            }
            list.add(j);
            ans[curIndex++] = nums[list.getFirst()];
        }
        return ans;

    }

    public static void main(String[] args) {
        int input[] = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(input, 3)));
    }
}
