package revision.string;

import java.util.ArrayList;

public class SearchPattern {
    static ArrayList<Integer> search(String pat, String txt) {
        int plen = pat.length();
        int tlen = txt.length();
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lpsArr = buildLPSArray(pat);
        while (i < tlen) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == plen) {
                ans.add(i - plen + 1);
                j = 0;
            }
            if (i < tlen && j < plen && txt.charAt(i) != pat.charAt(j)) {
                if (j > 0) {
                    j = lpsArr[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;

    }

    static int[] buildLPSArray(String pat) {
        int len = pat.length();
        int[] dp = new int[len];
        int patlen = 0;
        for (int i = 1; i < len; i++) {
            if (pat.charAt(i) == pat.charAt(patlen)) {
                dp[i] = ++patlen;
            } else {
                if (patlen > 0) {
                    patlen = dp[patlen - 1];
                    i--;
                }
            }
        }
        return dp;
    }
}
