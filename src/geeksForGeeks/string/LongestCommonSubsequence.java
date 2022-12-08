package geeksForGeeks.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return longestCommonSubsequenceRec(text1, text2, 0, 0, text1.length(), text2.length());
    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] memo = new int[len1+1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i + 1][j + 1] = 1 + memo[i][j];
                } else {
                    memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }
        return memo[len1][len2];
    }

    public static int longestCommonSubsequenceRec(String text1, String text2, int i, int j, int l1, int l2) {
        if (i >= l1 || j >= l2) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceRec(text1, text2, i + 1, j + 1, l1, l2);
        } else {
            int preComputedValue = memo[i][j];
            if (preComputedValue > -1) {
                return preComputedValue;
            }
            int value = Math.max(longestCommonSubsequenceRec(text1, text2, i, j + 1, l1, l2), longestCommonSubsequenceRec(text1, text2, i + 1, j, l1, l2));
            memo[i][j] = value;
            return value;
        }
    }



    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy",
                "hafcdqbgncrcbihkd"));
        System.out.println(longestCommonSubsequenceDP("pmjghexybyrgzczy",
                "hafcdqbgncrcbihkd"));
    }
}
