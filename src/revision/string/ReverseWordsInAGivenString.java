package revision.string;

import java.util.Arrays;

public class ReverseWordsInAGivenString {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        int len = ss.length;
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i <len; i++) {
            if(!ss[i].trim().isEmpty()){
                ans.append(reverse(ss[i].trim())).append(" ");
            }
        }
        return reverse(ans.toString().trim());
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  the  sky is blue ";
//        s = s.stripLeading();
//        s = s.stripTrailing();

        System.out.println(reverseWords(s));
    }
}
