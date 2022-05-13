package leetcode.top100.liked;

import static java.lang.Math.*;

//https://leetcode.com/problems/power-of-three/solution/
public class PowerOf3 {
    public boolean isPowerOfThreeDevide(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
    public static boolean isPowerOfThreeMul(int n) {
        if (n < 1) {
            return false;
        }
        if(n==1){
            return true;
        }

        int r=3;
        while (r<n && r<=1162261467) {
            r=r*3;
        }

        return r==n;
    }
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;

        if(n==1)
            return true;

        if(n%3!=0)
            return false;

        return isPowerOfThree(n/3);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThreeMul(
                2147483647));

       System.out.println( pow(3, floor(log(Integer.MAX_VALUE) / log(3))));

    }
}
