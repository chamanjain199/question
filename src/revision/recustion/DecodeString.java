package revision.recustion;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {

        Stack<String> strings = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int index = 0;
        int len = s.length();
        while (index < len) {
            char ch = s.charAt(index);
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!strings.isEmpty() && !Objects.equals(strings.peek(), "[")) {
                    sb.insert(0, strings.pop());
                }
                if (!strings.isEmpty()) {
                    strings.pop();
                    StringBuilder number = new StringBuilder();
                    while (!strings.isEmpty() && isNumber(strings.peek())) {
                        number.insert(0,strings.pop());
                    }
                    strings.push(sb.toString().repeat(Integer.parseInt(number.toString())));
                } else {
                    strings.push(sb.toString());
                }

            } else {
                strings.push(String.valueOf(ch));
            }
            index++;
        }
        while (!strings.isEmpty()) {
            ans.insert(0, strings.pop());
        }
        return ans.toString();

    }

    private static boolean isNumber(String peek) {
        char ch = peek.charAt(0);
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
}
