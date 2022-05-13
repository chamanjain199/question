package leetcode.daily.challenge;

import java.util.ArrayList;

import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static List<char[]> keyset = new ArrayList<>();
    static {
        keyset.add(new char[]{});
        keyset.add(new char[]{});
        keyset.add(new char[]{'a', 'b', 'c'});
        keyset.add(new char[]{'d', 'e', 'f'});
        keyset.add(new char[]{'g', 'h', 'i'});
        keyset.add(new char[]{'j', 'k', 'l'});
        keyset.add(new char[]{'m', 'n', 'o'});
        keyset.add(new char[]{'p', 'q', 'r', 's'});
        keyset.add(new char[]{'t', 'u', 'v'});
        keyset.add(new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] fchar = keyset.get(digits.charAt(0) - '0');
        List<String> result = new ArrayList<>(144);

        for (char c :
                fchar) {
            add(new StringBuilder().append(c), digits, 1, result);
        }

        return result;
    }

    private static void add(StringBuilder mystr, String digits, int index, List<String> result) {
        if (index >= digits.length()) {
            result.add(mystr.toString());
            return;
        }
        char[] fchar = keyset.get(digits.charAt(index) - '0');
        for (char c :
                fchar) {
//            StringBuilder sb = ;
//            sb.append(c);
            add(new StringBuilder(mystr).append(c), digits, index + 1, result);
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));

    }
}
