package geeksForGeeks.string;

import java.util.Arrays;

public class LeftmostNonRepeatingElement {
    static char nonrepeatingCharacter(String S) {
        int arr[] = new int[26];
        int len = S.length();
        Arrays.fill(arr, -1);
        for (int i = 0; i < len; i++) {
            int index = S.charAt(i) - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            } else {
                arr[index] = -2;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > -1) {
                ans = Math.min(arr[i], ans);
            }
        }
        return S.charAt(ans) ;
    }

    public static void main(String[] args) {

    }
}
