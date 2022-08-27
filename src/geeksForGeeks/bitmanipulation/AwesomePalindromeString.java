package geeksForGeeks.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class AwesomePalindromeString {
    public static int longestAwesome(String s) {
        Map<Integer, Integer> maskMap = new HashMap<>(s.length());
        int maskedNumber = 0;
        int max = 0;
        maskMap.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            maskedNumber ^= 1 << ((s.charAt(i) - '0'));
            Integer findMask = maskMap.get(maskedNumber);
            if (findMask != null) {
                max = Math.max(i - findMask, max);
            }
            for (int j = 0; j <= 9; j++) {
                int temp = (maskedNumber ^ (1 << j));
                Integer findOddMask = maskMap.get(temp);
                if (findOddMask != null) {
                    max = Math.max(i - findOddMask, max);
                }
            }
            if (findMask == null) {
                maskMap.put(maskedNumber, i);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestAwesome("940884"));
    }
}
