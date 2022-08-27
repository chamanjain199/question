package leetcode.weekly.contest;

public class GreatestEnglishLetterinUpperAndLowerCase {
    public static String greatestLetter(String s) {
        boolean[] uppercase = new boolean[26];
        boolean[] lower = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch <= 90) {
                uppercase[ch - 65] = true;
            } else {
                lower[ch - 97] = true;
            }
        }
        for (int i = 25; i>=0; i--) {
            if(uppercase[i] && lower[i]){
                return (char)(i+'A')+"";
            }
        }
        return "";

    }

    public static void main(String[] args) {
        System.out.println(greatestLetter("zZ"));
    }
}
