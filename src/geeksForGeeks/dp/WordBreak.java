package geeksForGeeks.dp;

import java.util.*;

public class WordBreak {
    static int dp[][];
    static Map<String, Boolean> dictionary;

    public static int wordBreak(String A, List<String> B) {
        dictionary = new HashMap<>();
        int len = A.length();
        for (String word : B) {
            dictionary.put(word, true);
        }
        dp = new int[len + 1][len + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return wordBreakRec(A, 0, 1, len) ? 1 : 0;
    }

    public static boolean wordBreakRec(String A, int i, int j, int len) {
        if (i == len) {
            return true;
        }
        if (j == len + 1 || i >= j) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean take = false;
        String sub = A.substring(i, j);
        if (dictionary.containsKey(sub)) {
            take = wordBreakRec(A, j, j + 1, len);
        }
        boolean notTake = wordBreakRec(A, i, j + 1, len);
        dp[i][j] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static void main(String[] args) {
        List<String> input = List.of("i", "like", "sam",
                "sung", "samsung", "mobile",
                "ice", "cream", "icecream",
                "man", "go", "mango");
        List<String> input1 = List.of("abc");
        System.out.println(wordBreak("ilike", input));

    }
}
