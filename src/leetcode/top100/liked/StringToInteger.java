package leetcode.top100.liked;

public class StringToInteger {
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.stripLeading();
        int len=s.length();
        if (len == 0) {
            return 0;
        }
        int sign = 1;
        int i = 0;
        char signChar = s.charAt(0);
        if (signChar == '-') {
            sign = -1;
            i++;
        } else if (signChar == '+') {
            i++;
        }
        int result = 0;
        int temp = 0;
        for (; i < len; i++) {

            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            temp = s.charAt(i) - '0';
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
        }
        return result * sign;

    }
    public int myAtoi2(String s) {
        if(s==null) return 0;

        s=s.trim();

        if(s.length()==0) return 0;

        int sign = +1;
        long ans = 0;
        if(s.charAt(0) == '-') sign = -1;

        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

        // initiate the starting pointer
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        while(i < s.length()) {
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            ans = ans * 10 + s.charAt(i)-'0';
            // check the conditions
            if(sign == -1 && -1*ans < MIN) return MIN;
            if(sign == 1 && ans > MAX) return MAX;

            i++;
        }

        return (int)(sign*ans);
    }

    public static void main(String[] args) {
        System.out.println(" yy " + (Integer.MAX_VALUE - 2147483646));
        System.out.println(myAtoi("-91283472332"));
    }
}
