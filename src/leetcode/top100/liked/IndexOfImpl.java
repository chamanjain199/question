package leetcode.top100.liked;

public class IndexOfImpl {

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        char[] needleAr = needle.toCharArray();
        int counter = 0;
        int index = 0;
        boolean found = false;
        char[] haystackAr = haystack.toCharArray();
        for (int i = 0; i < haystackAr.length; i++) {
            if (haystackAr[i] == needleAr[counter]) {
                counter++;
                if (counter == needleAr.length) {
                   return i - counter + 1;
                }
            } else {
                if (counter > 0) {
                    i = i - counter;
                    counter = 0;
                }
            }
        }
        if (!found) {
            return -1;
        }
        return index - counter + 1;

    }

    public static void main(String[] args) {

        System.out.println(strStr("ippi", "pi"));

    }
}
