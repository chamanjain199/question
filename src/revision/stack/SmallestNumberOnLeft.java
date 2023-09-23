package revision.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallestNumberOnLeft {
    static List<Integer> leftSmaller(int n, int a[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) stack.pop();
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            stack.push(a[i]);
        }
        return ans;
    }
}
