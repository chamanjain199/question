package revision.recustion;

public class ReverseString {
    public void reverseString(char[] s) {
        rec(s, 0, s.length - 1);
    }

    private void rec(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(s, start, end);
        rec(s, start + 1, end - 1);
    }

    private void swap(char[] chars, int start, int end) {
        char c = chars[start];
        chars[start] = chars[end];
        chars[end] = c;
    }
}
