package geeksForGeeks.string;

public class ReverseWordsInAGivenString {
    //Function to reverse words in a given string.
    static String reverseWords(String S) {
        StringBuilder stringBuilder = new StringBuilder(S);
        int len = S.length();
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (stringBuilder.charAt(i) == '.') {
                reverseString(stringBuilder, start, i);
                start = i + 1;
            }

        }
        reverseString(stringBuilder, start, len);
        reverseString(stringBuilder, 0, len);
        return stringBuilder.toString();

    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        int halfLen = (start + end) / 2;
        for (int i = start; i < halfLen; i++) {
            swap(sb, i, end - i - 1 + start);
        }
    }

    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        reverse1(0, len - 1, sb);
        int j = 0;
        for (int i = 0; i < sb.length();) {
            if (sb.charAt(i) == ' ') {
                reverse1(j, i - 1, sb);
                j = i + 1;
                i++;
                while (i< sb.length() && sb.charAt(i)==' ')
                {
                    sb.deleteCharAt(i);
                }
            } else {
                i++;
            }
        }
        reverse1(j, sb.length() - 1, sb);
        return sb.toString();

    }

    private static void reverse1(int start, int end, StringBuilder sb) {
        while (start < end) {
            swap1(start++, end--, sb);
        }
    }

    private static void swap1(int i, int j, StringBuilder sb) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords1("the sky is blue"));
    }
}
