package leetcode.top100.liked;

public class IsPalindrome {

    static boolean isValidChar(char c) {
        int i = c;
        return (i > 47 && i < 58) || (i > 64 && i < 91) || (i > 96 && i < 123);
    }
    static char convertLowerCase(char c) {
        int i = c;
        if(i<91){
            return c;
        }
        return (char)(i-32);
    }

    public static boolean isPalindrome(String s) {
        int j = s.length() - 1;
        int i = 0;
        while ( i!=j && j>0 && i<s.length()) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!isValidChar(ch1)) {
                i++;
                continue;
            }
            if (!isValidChar(ch2)) {
                j--;

                continue;
            }
            if ((ch1 != ch2) && convertLowerCase(ch1)!=convertLowerCase(ch2)) {
               return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("ss"));
    }
}
