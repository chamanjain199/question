package test;

public class GetIthBit {
    static boolean checkKthBit(int n, int k) {
        return (n & 1 << k) > 0;
    }

    static int setKthBit(int N, int K) {
        return N | 1 << K;
    }

    static int isBitSet(int N) {

        return (N != 0) && ((N & (N + 1)) == 0)?1:0;
    }

    public static void main(String[] args) {



    }
}
