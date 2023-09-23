package geeksForGeeks.string;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
    static ArrayList<Integer> kmp(String pat, String txt) {
        int patLen = pat.length();
        int txtLen = txt.length();
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lpsArr = buildLPSArray(pat);
        while (i < txtLen) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == patLen) {
                ans.add(i - j+1);
                j = lpsArr[j - 1];
            }
            if (i < txtLen && j < patLen && txt.charAt(i) != pat.charAt(j)) {
                if (j > 0) {
                    j = lpsArr[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    //is the beginning part of the pattern is again appearing or not
    public static int[] buildLPSArray(String pattern) {
        int patLen = 0;
        int i = 1;  // assuming in start, prefix is first single char
        int len = pattern.length();
        int[] arr = new int[len];
        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(patLen)) {
                patLen++;
                arr[i] = patLen;
                i++;
            } else {
                if (patLen > 0) {
                    patLen = arr[patLen - 1];  // check if its match with prefix of prefix
                                               // suppose pattern len is 6(abcabcd)  and abcabcdefgiabcabcr
                                               // now support i is at  17  (at r last me)
                                                //  r is not matching with d
                                                // now we can try to match r with index 3 because (abc) is matching before r with suffix of pattern
                } else {
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        //[0, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4]
        //[0, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4]
        System.out.println(   kmp("ababcabadabab","ababcabadabab"));
    }
}
