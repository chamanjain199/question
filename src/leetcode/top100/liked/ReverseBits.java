package leetcode.top100.liked;

public class ReverseBits {


    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

    public static int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                result = result | 1 << 31 - i;
            n >>= 1;
        }
        return result;
    }

    public static int reverseBits1(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i)
            if ((n >> i & 1) == 1)
                ans |= 1 << 31 - i;
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(reverseBits2(-3));

    }
}
