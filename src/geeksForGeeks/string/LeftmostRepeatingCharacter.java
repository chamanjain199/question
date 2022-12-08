package geeksForGeeks.string;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {
    static String firstRepChar(String s) {
        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        int len = s.length();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            } else {
                ans = Math.min(arr[index], ans);
            }
        }
        return s.charAt(ans) + "";
    }

    static String firstRepChar2(String s) {
        int len = s.length();
        boolean arr[] = new boolean[26];
        int ans = -1;
        for (int i = len - 1; i > 0; i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index]) {
                arr[index] = true;
            } else {
                ans = i;
            }

        }
        return s.charAt(ans) + "";
    }

    public static void main(String[] args) {
        System.out.println(firstRepChar("geeksforgeeks"));
    }
}
