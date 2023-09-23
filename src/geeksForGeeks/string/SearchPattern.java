package geeksForGeeks.string;

import java.util.ArrayList;

public class SearchPattern { //not working
    public static int[] buildLPSArray(String pattern) {
        int patLen = 0;
        int i = 1;
        int len = pattern.length();
        int[] arr = new int[len];
        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(patLen)) {
                patLen++;
                arr[i] = patLen;
                i++;
            } else {
                if (patLen > 0) {
                    patLen = arr[patLen - 1];
                } else {
                    i++;
                }
            }
        }
        return arr;
    }

    static ArrayList<Integer> search(String pat, String txt) {
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
                ans.add(i - patLen + 1);
                j = 0;
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

    public static void main(String[] args) {
        System.out.println(search("bat", "batmanandrobinarebat"));
    }
}
