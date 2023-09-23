package geeksForGeeks.string;

import java.util.Arrays;

public class LengthOfTheLongestSubstring {
    static int longestUniqueSubsttr(String S) {
        int[] countArr = new int[26];
        Arrays.fill(countArr, -1);
        int len = S.length();
        int j = 0;
        int maxLen = 0;
        int i = 0;
        for ( ;i < len; i++) {
            char ch = S.charAt(i);
            if (countArr[ch - 'a'] != -1 && countArr[ch - 'a'] >= j) {
                maxLen = Math.max(maxLen, i - j);
                j = countArr[ch - 'a'] + 1;
                countArr[ch - 'a'] = i;
            } else {
                countArr[ch - 'a'] = i;
            }
        }
        maxLen = Math.max(maxLen, i-j);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSubsttr("aabbcc"));
    }
}
