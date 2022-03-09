package leetcode.top100.liked;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {


    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(c + "");
            if (index < 0) {
                sb.append(c);
            } else {
                if (sb.length() > maxCount) {
                    maxCount = sb.length();
                }
                sb = sb.delete(0, index + 1);
                sb.append(c);
            }
        }
        if (sb.length() > maxCount) {
            maxCount = sb.length();
        }

        return maxCount;
    }

    public static int lengthOfLongestSubstring1(String s) {

        // not working
        int len = s.length();
        int maxCount = 0;
        StringBuilder sb = new StringBuilder(len);
        int count = 0;
        int lasRemovedIndex = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int index = sb.lastIndexOf(c + "");
            if (index < 0) {
                count++;

                sb.append(c);
            } else {

                if (index >= lasRemovedIndex) {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = count - (index-1);

                    lasRemovedIndex = index;
                } else {
                    count++;
                }
                sb.append(c);
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }


        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("aabaab!bb"));
    }
}
