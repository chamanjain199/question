package leetcode.top100.liked;

public class ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        int preRev;
        while (x != 0) {
            int temp = x % 10;
            preRev = rev;
            rev = rev * 10 + temp;


            x = x / 10;
            if (rev > ((Integer.MAX_VALUE / 10) + x % 10)) {
                int calPrev = rev - temp;
                calPrev = calPrev / 10;
                if (preRev != calPrev) {
                    return 0;
                }
            }

        }
        return rev;

    }

    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 ) return 0;
            if (rev < Integer.MIN_VALUE / 10 ) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-345));
    }
}
