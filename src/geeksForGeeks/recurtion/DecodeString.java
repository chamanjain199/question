package geeksForGeeks.recurtion;

public class DecodeString {

    int pos = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            sb.append(decodeStringSB(s));
        }
        return sb.toString();
    }

    private StringBuilder decodeStringSB(String s) {

        int count = 0;
        if (pos < s.length() && isDigit(s.charAt(pos))) {
            StringBuilder number = new StringBuilder();
            while (pos < s.length() && (isDigit(s.charAt(pos)))) {
                number.append(s.charAt(pos));
                pos++;
            }
            count = Integer.parseInt(number.toString());
            pos++;
            StringBuilder output = decodeStringSB(s);
            String withRepeat = output.toString().repeat(count);
            if (pos < s.length() && s.charAt(pos) == ']') {
                pos++;
                return new StringBuilder(withRepeat);
            } else {
                return new StringBuilder(withRepeat).append(decodeStringSB(s));
            }

        }
        if (pos < s.length() && isLetter(s.charAt(pos))) {
            StringBuilder string = new StringBuilder();
            while (pos < s.length() && (isLetter(s.charAt(pos)))) {
                string.append(s.charAt(pos));
                pos++;
            }
            if (pos < s.length() && s.charAt(pos) == ']') {
                pos++;
                return string;
            } else {
                return string.append(decodeStringSB(s));
            }


        }
        pos++;
        return new StringBuilder();
    }

    static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
//3[z]2[2[y]pq4[2[jk]e1[f]]]ef
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
