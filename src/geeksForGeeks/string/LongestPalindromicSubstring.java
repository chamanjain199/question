package geeksForGeeks.string;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] allSubStrings = new boolean[len][len];
        int firstIndex = 0;
        int lastIndex = 0;

        for (int i = 0; i < len; i++) {
            allSubStrings[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                allSubStrings[i][i + 1] = true;
                firstIndex = i;
                lastIndex = i + 1;
            }
        }
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 2, k = 0; j < len; j++, k++) {
                if (s.charAt(k) == s.charAt(j) && allSubStrings[k + 1][j - 1]) {
                    allSubStrings[k][j] = true;
                    firstIndex = k;
                    lastIndex = j;
                }
            }
        }
        return s.substring(firstIndex, lastIndex+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("agfgb"));
    }
}
