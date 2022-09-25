package geeksForGeeks.recurtion;

import java.util.ArrayList;

public class AllPossibleString {
    static ArrayList<String> finalAnswer = new ArrayList<>();

    static ArrayList<String> spaceString(String str) {
        helper(str, new StringBuilder(), str.length(), 0);
        return finalAnswer;
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
