package revision.recustion;

import java.util.ArrayList;

public class PrintAllPossibleStrings {

    ArrayList<String> arrayList = new ArrayList<>();

    public ArrayList<String> spaceString(String str) {
        helper(str, 0, str.length(), "");
        return arrayList;
    }

    private void helper(String original, int index, int len, String sb) {
        if (index == len) {
            arrayList.add(sb);
            return;
        }
        helper(original, index + 1, len, sb + original.charAt(index));
        if (index < len - 1)
            helper(original, index + 1, len, sb + original.charAt(index) + " ");

    }

    public static void main(String[] args) {
        PrintAllPossibleStrings obj = new PrintAllPossibleStrings();
        obj.spaceString("ABC");
        System.out.println(obj.arrayList);
    }
}
