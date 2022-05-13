package self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int answer[] = new int[n];

        int size = nums2.length;
        int nextGreatest[] = new int[size];
        int largest = 0;

        //HashMap<Integer, Integer> hashMap = new HashMap<>();
        int hashMap[] = new int[10001];

        for (int idx = size - 1; idx >= 0; --idx) {
            if (nums2[idx] >= largest) {
                nextGreatest[idx] = -1;
                hashMap[nums2[idx]] = -1;
                //hashMap.put(nums2[idx], -1);
                largest = nums2[idx];
                continue;
            }
            int pos = 1;
            while (nums2[idx + pos] <= nums2[idx]) {
                pos += nextGreatest[idx + pos];
            }
            nextGreatest[idx] = pos;
            hashMap[nums2[idx]] = nums2[idx + pos];
            //hashMap.put(nums2[idx], nums2[idx + pos]);
        }

        for (int idx = 0; idx < n; ++idx) {
            answer[idx] = hashMap[nums1[idx]];//hashMap.get(nums1[idx]);
        }
        return answer;
    }

    public static int[] nextGreaterElementRLAvoidMap(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        stack.ensureCapacity(nums2.length);
        int[] arrs = new int[10001];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                arrs[nums2[i]] = -1;
            } else {
                arrs[nums2[i]] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = arrs[nums1[i]];
        }
        return ans;
    }

    public static int[] nextGreaterElementRL(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static int[] nextGreaterElementLR(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);
        stack.push(0);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int pos = stack.peek();
                map.put(nums2[pos], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {  // there is no next greather for remaining that by they were left so assign -1 for all
            int pos = stack.peek();
            map.put(nums2[pos], -1);
            stack.pop();
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(nextGreaterElementRL(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
