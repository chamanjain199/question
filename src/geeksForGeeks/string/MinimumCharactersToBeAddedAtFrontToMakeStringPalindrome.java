package geeksForGeeks.string;

public class MinimumCharactersToBeAddedAtFrontToMakeStringPalindrome {
    public static int minChar(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(new StringBuffer(str).reverse());
        System.out.println(sb);
        int[] lpaArray = buildLPSArray(sb.toString());
        return str.length() - lpaArray[lpaArray.length - 1];
    }

    public static int[] buildLPSArray(String s) {
        int len = s.length();
        int i = 1;
        int repeatLen = 0;
        int[] ans = new int[len];
        while (i < len) {
            if (s.charAt(i) == s.charAt(repeatLen)) {
                repeatLen++;
                ans[i] = repeatLen;
                i++;
            } else {
                if (repeatLen > 0) {
                    repeatLen = ans[repeatLen - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minChar("abad"));
    }
}
