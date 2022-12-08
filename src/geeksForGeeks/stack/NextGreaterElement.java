package geeksForGeeks.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
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
        int n = nums2.length;
        int n2 = nums1.length;
        int[] ans = new int[n2];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
            if (stack.isEmpty()) {
                hashMap.put(nums2[i], -1);
            } else {
                hashMap.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n2; i++) {
            ans[i] = hashMap.get(nums1[i]);
        }
        return ans;

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = (2 * n - 1); i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) stack.pop();
            if (stack.isEmpty()) {
                ans[i % n] = -1;
            } else {
                ans[i % n] = stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
