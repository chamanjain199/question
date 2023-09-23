package revision.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long ans[] = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            long num = arr[i];

            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[len1];
        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) stack.pop();
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < len1; i++) {
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
