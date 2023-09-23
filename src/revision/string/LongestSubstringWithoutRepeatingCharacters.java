package revision.string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int maxLen = 0;
        while (r < n) {
            Character c = s.charAt(r);
            while (hashSet.contains(c)) {
                hashSet.remove(s.charAt(l++));
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
            hashSet.add(c);
        }
        return maxLen;

    }

    public static int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLen = 0;
        while (r < n) {
            Character c = s.charAt(r);
            Integer lastFoundIndex = hashMap.get(c);
            if (lastFoundIndex != null && lastFoundIndex>=l) {
                l = lastFoundIndex + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hashMap.put(c, r);
            r++;
        }
        return maxLen;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringOptimized("abba"));
    }
}
