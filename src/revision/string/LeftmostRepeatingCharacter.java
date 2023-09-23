package revision.string;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {
    static String firstRepChar(String s) {
        int n = s.length();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int index;
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            index = s.charAt(i) - 'a';
            if (arr[index] != -1) {
                arr[index] = index;
            } else {
                ans = Math.min(ans, arr[index]);
            }
        }
        return String.valueOf(arr[ans]);
    }

    //https://practice.geeksforgeeks.org/problems/repeated-character2058/1
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
}
