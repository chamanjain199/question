package leetcode.top100.liked;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValidTimeTaking(String s) {

        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        int change = 0;
        while (!sb.equals("")) {

            if (change == 1) {
                break;
            }
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");


            if (len == s.length()) {
                change = 1;
            }
            len = s.length();

        }
        return s.equals("");

    }

    static Map<Character, Integer> mapping = Map.of('(', 1, '[', 2, '{', 3, ')', -1, ']', -2, '}', -3);

    public static boolean isValid54(String s) {
        char chs[] = s.toCharArray();
        Stack<Integer> queue = new Stack<>();

        for (int i = 0; i < chs.length; i++) {

            int value = mapping.get(chs[i]);
            if (value > 0) {
                queue.push(value);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                if ((-value) != queue.pop()) {
                    return false;
                }

            }
        }
        return queue.isEmpty();

    }

    public static boolean isOpening(char ch) {
        return (ch == '(' || ch == '[' || ch == '{');
    }

    public static boolean isPaired(char opening, char closing) {
        return (opening == 40 && closing == 41) ||
                (opening == 91 && closing == 93) ||
                (opening == 123 && closing == 125);
    }
    public static char getClosing(char opening) {
        return switch (opening){
            case '('->')';
            case '['->']';
            default -> '}';
        };

    }

    public static boolean isValid9938(String s) {
        if(s.length()==0 || s.length()==1){
            return false;
        }
        char chs[] = s.toCharArray();
        char chsOp[] = new char[chs.length/2];


        int chO=-1;
        for (int i = 0; i < chs.length; i++) {



            if (isOpening(chs[i])) {
                if(chO==chsOp.length-1){
                    return false;
                }
                chsOp[++chO]=getClosing(chs[i]);
            } else {
                if (chO==-1) {
                    return false;
                }
                if (chs[i]==chsOp[chO]) {

                    chO--;
                } else {
                    return false;
                }

            }
        }
        return chO==-1;

    }

    public boolean isValid72(String s) {
        char chs[] = s.toCharArray();
        StringBuilder sbO = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {


            if (isOpening(chs[i])) {
                sbO.append(chs[i]);
            } else {
                if (sbO.isEmpty()) {
                    return false;
                }

                if (isPaired(sbO.charAt(sbO.length() - 1),chs[i])) {

                    sbO.deleteCharAt(sbO.length() - 1);
                } else {
                    return false;
                }

            }
        }
        return sbO.isEmpty();
    }
    public static void main(String[] args) {
//        "()"
//        "()[]{}"
//        "(]"
        System.out.println(isValid9938("[["));
    }
}