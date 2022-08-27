package geeksForGeeks.bitmanipulation;

public class CountBitSetInAGivenRange {
    public static int countSetBits(int n) {
        if (n <= 0) {
            return 0;
        }
        int x = max2sPowerBelowN(n);
        int twoUptoMaxPowerOf2 = x * (1 << (x - 1));
        int extra = n - (1 << x) + 1;
        int rest = countSetBits(extra - 1);
        return twoUptoMaxPowerOf2 + extra + rest;
    }

    private static int max2sPowerBelowN(int n) {
        if(n==1){
            return 0;
        }
        int count = 0;
        int temp = 1;
        while (temp <= n) {
            temp <<= 1;
            count++;
        }
        return count-1 ;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(31));
    }
}
