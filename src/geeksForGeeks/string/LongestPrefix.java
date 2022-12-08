package geeksForGeeks.string;

public class LongestPrefix {
    public static String longestPrefix(String s) {
        int len = s.length();
        int prefixLen = 0;
        int i = 1;
        int[] arr = new int[len];
        while (i < len) {
            if (s.charAt(i) == s.charAt(prefixLen)) {
                prefixLen++;
                arr[i] = prefixLen;
                i++;
            } else {
                if (prefixLen > 0) {
                    prefixLen = arr[prefixLen - 1];
                }else{
                    i++;
                }
            }
        }

        return s.substring(0, prefixLen);
    }

    public static String longestPrefix1(String s) {
        int dp[] = new int[s.length()], j = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(j))
                dp[i] = ++j;
            else if (j > 0) {
                j = dp[j - 1];
                --i;
            }
        }
        return s.substring(0, j);
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("bba"));
    }
}
