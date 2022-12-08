package geeksForGeeks.string;

import java.util.ArrayList;

public class RabinKarpAlgorithm {
    static final int d = 26;
    static final int q = 101;

    static ArrayList<Integer> search(String pat, String S) {
        int len1 = pat.length();
        int len2 = S.length();
        int h = 1;
        for (int i = 1; i < len1; i++)
            h = (h * d) % q;
        int patRollingHash = 0;
        int strRollingHash = 0;
        int sub = 'a' - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            patRollingHash = (patRollingHash * d + (pat.charAt(i) - sub)) % q;
            strRollingHash = (strRollingHash * d + (S.charAt(i) - sub)) % q;
        }
        int loopLen = len2 - len1;
        for (int i = 0; i <= loopLen; i++) {
            if (patRollingHash == strRollingHash) {
                int j = 0;
                for (; j < len1; j++) {
                    if (pat.charAt(j) != S.charAt(i + j)) {
                        break;
                    }
                }
                if (j == len1) {
                    ans.add(i + 1);
                }
            }
            if (i < loopLen) {
                strRollingHash = (d * (strRollingHash - (S.charAt(i) - sub) * h) + (S.charAt(i + len1) - sub)) % q;
                if (strRollingHash < 0) strRollingHash = strRollingHash + q;
            }

        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(search("bat", "batubat"));
    }
}
