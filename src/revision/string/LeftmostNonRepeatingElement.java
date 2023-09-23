package revision.string;

import java.util.Arrays;

public class LeftmostNonRepeatingElement {
    static char nonrepeatingCharacter(String S) {
        int n = S.length();
        int[] arr = new int[26];
        int index;
        int ans = n;
        Arrays.fill(arr, -1);
        for (int i = n - 1; i >= 0; i--) {
            index = S.charAt(i) - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            } else {
                arr[index] = -2;
            }
        }

        return ans == n ? '$' : S.charAt(ans);
    }

    public static void main(String[] args) {
        System.out.println(nonrepeatingCharacter("zzz"));
    }
}
