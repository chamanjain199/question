package geeksForGeeks.string;

public class SmallestWindowInAStringContainingAllTheCharactersOfAnotherString {
    public static String smallestWindow(String s, String t) {
        int[] patternMap = new int[26];
        int[] txtMap = new int[26];
        int len1 = s.length();
        int len2 = t.length();
        int countValidChar = 0;
        int smallestWindow = len1;
        for (int i = 0; i < len2; i++) {
            patternMap[t.charAt(i) - 'a']++;
        }

        int i = 0;
        int idx;
        int leftIndex = 0;
        String ans = "";
        while (i<len1) {
            while (i<len1 && countValidChar < len2) {
                idx = s.charAt(i) - 'a';
                txtMap[idx]++;
                if (patternMap[idx] != 0 && txtMap[idx] <= patternMap[idx]) {
                    countValidChar++;
                }
                i++;
            }
            while (countValidChar == len2 && leftIndex < len1) {
                idx = s.charAt(leftIndex) - 'a';

                txtMap[idx]--;
                if (patternMap[idx] != 0 && txtMap[idx] < patternMap[idx]) {
                    countValidChar--;
                }
                if (countValidChar < len2 && (i - leftIndex) <= smallestWindow) {
                    smallestWindow = i - leftIndex;
                    ans = s.substring(leftIndex, i);
                }
                leftIndex++;
            }
        }
        return ans;
    }
    public static String smallestWindow2(String s, String t) {
        int[] patternMap = new int[57];
        int[] txtMap = new int[57];
        int len1 = s.length();
        int len2 = t.length();
        int countValidChar = 0;
        int smallestWindow = len1;
        for (int i = 0; i < len2; i++) {
            patternMap[t.charAt(i) - 'A']++;
        }

        int i = 0;
        int idx;
        int leftIndex = 0;
        String ans = "";
        while (i<len1) {
            while (i<len1 && countValidChar < len2) {
                idx = s.charAt(i) - 'A';
                txtMap[idx]++;
                if (patternMap[idx] != 0 && txtMap[idx] <= patternMap[idx]) {
                    countValidChar++;
                }
                i++;
            }
            while (countValidChar == len2 && leftIndex < len1) {
                idx = s.charAt(leftIndex) - 'A';

                txtMap[idx]--;
                if (patternMap[idx] != 0 && txtMap[idx] < patternMap[idx]) {
                    countValidChar--;
                }
                if (countValidChar < len2 && (i - leftIndex) <=smallestWindow) {
                    smallestWindow = i - leftIndex;
                    ans = s.substring(leftIndex, i);
                }
                leftIndex++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(smallestWindow2("a", "a"));
    }
}
