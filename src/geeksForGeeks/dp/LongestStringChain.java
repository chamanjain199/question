package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int len = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (isPossible(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;

    }

    private boolean isPossible(String word, String word1) {
        if (word.length() != (word1.length() + 1)) {
            return false;
        }
        int len1 = word.length();
        int len2 = word1.length();
        int first = 0;
        int second = 0;
        while (first < len1) {
            if (second < len2 && word.charAt(first) == word1.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return first == len1 && second == len2;
    }

    public static void main(String[] args) {
        String[] art = new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        LongestStringChain obj = new LongestStringChain();
        System.out.println(obj.longestStrChain(art));
    }

}
