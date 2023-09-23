package geeksForGeeks.recurtion;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/print-all-possible-strings/1
public class AllPossibleString {
    static ArrayList<String> finalAnswer = new ArrayList<>();

    static ArrayList<String> spaceString(String str) {
        helper(str, new StringBuilder(), str.length(), 0);
        return finalAnswer;
    }
    public ArrayList<String> spaceString2(String str) {
        helper2(str, 0, str.length(), "");
        return finalAnswer;
    }

    private void helper2(String original, int index, int len, String sb) {
        if (index == len) {
            finalAnswer.add(sb);
            return;
        }
        helper2(original, index + 1, len, sb + original.charAt(index));
        if (index < len - 1)
            helper2(original, index + 1, len, sb + original.charAt(index) + " ");

    }

    private static void helper(String original, StringBuilder sb, int size, int index) {

        if (index == size) {
            finalAnswer.add(sb.toString());
            return;
        }

        String subString = original.substring(0, 1);
        helper(original.substring(1), sb.append(subString), size, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        if (original.length() > 1) {
            helper(original.substring(1), sb.append(subString).append("_"), size, index + 1);
            sb.deleteCharAt(sb.length() - 1);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(spaceString("ABC"));
    }
}
