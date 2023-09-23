package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static char[][] charMapping = new char[][]{
            {},
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        int[] digitsArr = new int[len];
        char[] chs = digits.toCharArray();
        for (int i = 0; i < len; i++) {
            digitsArr[i] = (chs[i] -'0')-1;
        }
        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty())
            letterCombinationsRec(len, digitsArr, new StringBuilder(), 0, ans);
        return ans;
    }

    public void letterCombinationsRec(int len, int[] digits, StringBuilder sb, int index, List<String> temp) {
        if (index == len) {
            temp.add(sb.toString());
            return;
        }
        char[] chars = charMapping[digits[index]];
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i] );
            letterCombinationsRec(len, digits, sb, index + 1, temp);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj=new LetterCombinationsOfAPhoneNumber();
        System.out.println(obj.letterCombinations("12"));
    }
}
