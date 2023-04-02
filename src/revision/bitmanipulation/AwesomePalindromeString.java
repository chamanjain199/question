package revision.bitmanipulation;

import java.util.HashMap;

public class AwesomePalindromeString {

    /*
     Properties of palindrome are.
     Frequency of all char must be either even or at max one char can be odd number of times.

    */


    public int longestAwesome(String s) {
        HashMap<Integer, Integer> bitPatternMap = new HashMap<>(s.length());
        bitPatternMap.put(0, -1);
        int mask = 0;
        int max = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            mask ^= 1 << (s.charAt(i) - '0');
            Integer findMask = bitPatternMap.get(mask);  // matching for same mask
            if (findMask != null) {
                max = Math.max(max, i - findMask);
            }
            for (int j = 0; j <= 9; j++) {
                int temp = (mask ^ (1 << (j)));
                Integer findOldMask = bitPatternMap.get(temp); //matching with by changing one big because one bit can have odd frequency
                if (findOldMask != null) {
                    max = Math.max(max, i - findOldMask);
                }
            }
            if (findMask == null) {  // if a mask already present we need to initial index of that mask so , do not replace with later index
                bitPatternMap.put(mask, i);
            }
        }
        return max;
    }
}
