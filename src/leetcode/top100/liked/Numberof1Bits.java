package leetcode.top100.liked;

import java.awt.desktop.SystemEventListener;

public class Numberof1Bits {

    public static int hammingWeight(int n) {

        System.out.println(Integer.toBinaryString(n));

        int count = 0;
        int zeroesBeforeFirstOne = 0;
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = Math.abs(n);
        }
        while (n!=0) {
            if ((n % 2) == 1) {
                count++;
            } else {
                if (count == 0)
                    zeroesBeforeFirstOne++;
            }
            n = n / 2;

        }
        if(isNegative){
            return 32-zeroesBeforeFirstOne-count+1;
        }
        return count;
    }

    public static int hammingWeightBest(int n) {
        System.out.println(Integer.toBinaryString(n));

        System.out.println(Integer.toBinaryString(n>>1));
        System.out.println(Integer.toBinaryString( 1));

        System.out.println(Integer.toBinaryString(n>>1 & 1));

        n=n>>1;
        System.out.println(Integer.toBinaryString(n>>1));
//        1 0 1
//        0 0 1
//            ======
//        0 0 1
        int count = 0;
        for (int i = 0; i<32; i++) {
//            System.out.println((n>>i));
//            System.out.println((n>>i & 1));

            if (((n>>i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer.bitCount(10);
        System.out.println(hammingWeightBest(10));
    }
}
