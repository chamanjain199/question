package geeksForGeeks.recurtion;

public class RecursivePower {
    static int RecursivePower(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * RecursivePower(n, p - 1);
    }

    static int fastPower(int n, int p) {
        int res = 1;
        while (p != 0) {
            if ((p & 1) != 0) {
                res *= n;
            }
            n *= n;
            p >>= 1;
        }
        return res;
    }

    static long power(int N,int R)
        {

            long res = 1;
            while (R > 0) {
                if ((R & 1) != 0) {
                    res =((res%1000000007)* (N%1000000007))%1000000007;
                    R --;
                }
                N = ((N%1000000007)*(N%1000000007))%1000000007;
                R >>= 1;
            }
            return res;
        }




    public static void main(String[] args) {
        System.out.println(power(2,2));
    }
}
