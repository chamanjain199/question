package leetcode.top100.liked;



public class LongestCommonString {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int sm = strs[0].length();
        char mc[] = strs[0].toCharArray();


        for (int i = 0; i < strs.length; i++) {
            char sub[] = strs[i].toCharArray();

            sm = Math.min(sm, sub.length);
            for (int j = 0; j < sm; j++) {
                if (mc[j] == sub[j]) {
                    continue;
                } else {
                    sm = j;
                }
            }
        }

        return strs[0].substring(0, sm);

    }

    public static void main(String[] args) {


        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "florine"}));

    }
}
