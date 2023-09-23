package revision.string;

public class MinimumCharactersToBeAddedAtFrontToMakeStringPalindrome {
    public static int minChar(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(new StringBuilder(str).reverse());
        int[] lps = buildLpsArray(sb.toString());
        return str.length()-lps[lps.length-1];
    }

    private static int[] buildLpsArray(String str) {
        int len = str.length();
        int[] dp = new int[len];
        int patLen = 0;
        for (int i = 1; i < len; i++) {
            if (str.charAt(patLen) == str.charAt(i)) {
                dp[i] = ++patLen;
            } else if (patLen > 0) {
                patLen = dp[patLen - 1];
                i--;
            }
        }
        return dp;
    }
}
