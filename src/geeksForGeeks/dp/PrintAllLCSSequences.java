package geeksForGeeks.dp;

import java.util.*;

public class PrintAllLCSSequences {
    public static ArrayList<String> lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int index = dp[m][n];
        int temp = index;
        char[] lcs = new char[index + 1];
        lcs[index] = ' ';
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcs[index - 1] = a.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        result.add(new String(lcs).trim());
        for (int k = 0; k < m; k++) {
            if (a.charAt(k) == lcs[0]) {
                StringBuilder sb = new StringBuilder();
                int x = k + 1, y = temp;
                while (x < m && y < n) {
                    if (a.charAt(x) == b.charAt(y)) {
                        sb.append(a.charAt(x));
                        x++;
                        y++;
                    } else if (a.charAt(x) < b.charAt(y)) {
                        x++;
                    } else {
                        y++;
                    }
                }
                if (sb.length() == temp - 1) {
                    result.add(sb.toString());
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        PrintAllLCSSequences obj = new PrintAllLCSSequences();
        System.out.println(obj.lcs("b", "eeabfc"));
    }
}


