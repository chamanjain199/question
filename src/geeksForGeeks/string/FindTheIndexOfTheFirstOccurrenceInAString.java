package geeksForGeeks.string;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        int[] lpsArray = buildLPSArray(needle);
        int i = 0;
        int j = 0;
        while (i < len1) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == len2) {
                return i - j + 1;
            }
            if (i < len1 && haystack.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = lpsArray[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;

    }

    public static int[] buildLPSArray(String pattern) {
        int len = pattern.length();
        int[] arr = new int[len];
        int i = 1;
        int preFixRepeatLen = 0;
        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(preFixRepeatLen)) {
                preFixRepeatLen++;
                arr[i] = preFixRepeatLen;
                i++;
            } else {
                if (preFixRepeatLen > 0) {
                    preFixRepeatLen = arr[preFixRepeatLen - 1];
                } else {
                    i++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(strStr("leetcode", "leeto"));
    }
}
