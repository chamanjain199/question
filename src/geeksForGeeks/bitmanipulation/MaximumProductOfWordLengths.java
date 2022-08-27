package geeksForGeeks.bitmanipulation;

import java.util.List;

public class MaximumProductOfWordLengths {
    public static int maxProduct(String[] words) {
        int length = words.length;
        int[] binaryOfWords = new int[length];
        for (int i = 0; i < length; i++) {
            for (char ch :
                    words[i].toCharArray()) {
                binaryOfWords[i] |= 1 << (ch - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((binaryOfWords[i] & binaryOfWords[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));

    }
}

