package self.string;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
    static ArrayList<Integer> kmp(String pat, String txt) {
        int i = 0;
        int j = 0;
        int txtLen = txt.length();
        int patLen = pat.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int patA[] = buildLPSArray(pat);
        while (i < txtLen) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == patLen) {
                ans.add(i - j + 1);
                j = patA[j - 1];
            }
            if (i < txtLen && j < patLen && txt.charAt(i) != pat.charAt(j)) {
                if (j > 0) {
                    j = patA[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    public static int[] buildLPSArray(String pattern) {
        int suffix = 0;

        int n = pattern.length();
        int i = 1;
        int[] patArr = new int[n];
        while (i < n) {

            if (pattern.charAt(suffix) == pattern.charAt(i)) {
                suffix++;
                patArr[i] = suffix;
                i++;
            } else {
                if (suffix > 0) {
                    //abcabc  [0,0,0,1,2,3]   abcabcuabcabh [0,0,0,1,2,3,0,1,2,3,4,5,0]
                    //for suffix =5 will replace by 2
                    suffix = patArr[suffix - 1];
                } else {
                    i++;
                }
            }
        }
        return patArr;

    }
}
