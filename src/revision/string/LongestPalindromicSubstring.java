package revision.string;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int fromIndex = 0;
        int lastIndex = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                fromIndex = i;
                lastIndex = i + 1;
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = i, k = 0; j < len; j++, k++) {
                if (s.charAt(k) == s.charAt(j) && dp[k + 1][j - 1]) {
                    dp[k][j] = true;
                    fromIndex = k;
                    lastIndex = j;
                }
            }
        }
        return s.substring(fromIndex, lastIndex + 1);
    }




    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));

    }
}
