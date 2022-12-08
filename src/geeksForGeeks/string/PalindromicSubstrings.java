package geeksForGeeks.string;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        boolean[][] allSubStrings = new boolean[len][len];
        count += len;

        for (int i = 0; i < len; i++) {
            allSubStrings[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                allSubStrings[i][i + 1] = true;
            }
        }
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 2, k = 0; j < len; j++, k++) {
                if (s.charAt(k) == s.charAt(j) && allSubStrings[k + 1][j - 1]) {
                    count++;
                    allSubStrings[k][j] = true;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }
}
