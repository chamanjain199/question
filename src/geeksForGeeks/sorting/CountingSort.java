package geeksForGeeks.sorting;

import java.util.Arrays;

public class CountingSort {
    public static String countSort(String arr) {
        char[] chars = arr.toCharArray();
        char[] output = new char[chars.length ];

        int max = Integer.MIN_VALUE;
        for (int ch : chars) {
            max = Math.max(max, ch - 'a');
        }
        max = max + 1;
        int[] tempArr = new int[max];
        for (int ch : chars) {
            tempArr[ch - 'a']++;
        }
        for (int i = 1; i < max; i++) {
            tempArr[i] += tempArr[i - 1];
        }
        for (int i = arr.length() - 1; i >= 0; i--) {
            int index = chars[i] - 'a';
            int idx = tempArr[index];
            output[idx - 1] = chars[i];
            tempArr[index]--;
        }
        return new String(output);

    }

    public static void main(String[] args) {
        System.out.println(countSort("geeksforgeeks"));
    }
}

