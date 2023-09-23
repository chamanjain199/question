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
        return String.valueOf(s.charAt(ans));
    }

    static char firstRepChar2(String S) {
        int n = S.length();
        boolean[] arr = new boolean[26];
        int index;
        int ans = n + 1;
        for (int i = n - 1; i >= 0; i--) {
            index = S.charAt(i) - 'a';
            if (arr[index]) {
                ans = i;
            } else {
                arr[index] = true;
            }
        }
        return ans==(n+1)?'#':S.charAt(ans);
    }

    public static void main(String[] args) {
        System.out.println(firstRepChar2("geeksforgeeks"));
    }
}
