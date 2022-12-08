package geeksForGeeks.string;

public class LongestCommonPrefix {
    static String  longestCommonPrefix(String arr[], int n) {
        StringBuilder sb = new StringBuilder();
        int len = arr[0].length();
        String firstStr = arr[0];
        char ftrstStrChar;
        loop1:
        for (int i = 0; i < len; i++) {
            ftrstStrChar = firstStr.charAt(i);
            for (int j = 1; j < n; j++) {
                if (i >= arr[j].length() || arr[j].charAt(i) != ftrstStrChar) {
                    break loop1;
                }
            }
            sb.append(ftrstStrChar);
        }
        return sb.isEmpty()?"-1":sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"},3));
    }

}
