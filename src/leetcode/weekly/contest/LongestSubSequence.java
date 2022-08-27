package leetcode.weekly.contest;

public class LongestSubSequence {
    public static int longestSubsequence(String s, int k) {


        int num = 0;

        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            if (s.charAt(i) == '1') {
                num |= (1 << j);
            }
            if (num > k) {
                num ^= (1 << j);
                break;
            }
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010",5));
    }
}
