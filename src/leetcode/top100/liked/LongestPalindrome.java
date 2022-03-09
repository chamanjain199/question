package leetcode.top100.liked;

public class LongestPalindrome {

    private static boolean isPalindrome(String str) {
        char ch[] = str.toCharArray();
        for (int i = 0, j = ch.length - 1; i < ch.length / 2; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String max = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j <= len; j++) {
                String sub = s.substring(i, j);
                boolean isPalindrome = isPalindrome(sub);
                if (isPalindrome) {
                    if (sub.length() > (i - j)) {
                        max = sub;
                    }
                }
                System.out.println(s.substring(i, j) + " " + isPalindrome);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));

    }
}
