package revision.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        int flen = first.length();
        char c;
        StringBuilder sb = new StringBuilder();
        loop1:
        for (int i = 0; i < flen; i++) {
            c = first.charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    break loop1;
                }
            }
            sb.append(c);

        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
