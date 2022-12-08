package geeksForGeeks.string;

public class Palindrome {
    int isPalindrome(String S) {
        int len = S.length();
        int halfLen = len / 2;

        for (int i = 0; i < halfLen; i++) {
            if (S.charAt(i) != S.charAt(len - 1 - i)) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
