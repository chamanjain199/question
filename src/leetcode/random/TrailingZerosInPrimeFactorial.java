package leetcode.random;

public class TrailingZerosInPrimeFactorial {

    public int trailingZeroes(int n) {

        int numOfTrailingZeros=0;
        for (int i = 5; i <=n ; i=i*5) {
            numOfTrailingZeros+=n/i;
        }
        return numOfTrailingZeros;

    }
    public int trailingZeroes1(int n) {

        int res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;

    }


    public static void main(String[] args) {

    }
}
