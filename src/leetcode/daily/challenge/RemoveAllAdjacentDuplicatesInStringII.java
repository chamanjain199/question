package leetcode.daily.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static String removeDuplicates(String s, int k) {
        Stack<Map<Character, Integer>> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        char pre = s.charAt(0);
        map.put(pre, 1);
        stack.push(map);

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pre == ch) {

                int count = map.get(ch);
                System.out.println(count+" "+ch+"  "+i);
                if (count == k - 1) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        pre=' ';
                        map = new HashMap<>();
                    } else {

                        map = stack.peek();
                        pre = map.keySet().iterator().next();
                    }
                } else {
                    map.put(ch, ++count);
                }
            } else {
                pre = ch;
                map = new HashMap<>();
                map.put(ch, 1);
                stack.push(map);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map<Character, Integer> map1 :
                stack) {
            sb.append(map1.keySet().stream().map(String::valueOf).collect(Collectors.joining()).repeat(map1.values().iterator().next()));

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz", 5));

    }
}
