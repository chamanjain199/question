package geeksForGeeks.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    // Function for finding maximum and value pair
    public static int[] nearestSmallerElement(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 6, 1};

        System.out.println(Arrays.toString(nearestSmallerElement(arr, arr.length)));
    }
}
