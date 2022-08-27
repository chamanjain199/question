package geeksForGeeks.bitmanipulation;

public class CountSetBit {
    public static int naiveSol(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    public static int naiveSol2(int n) {
        int res = 0;
        while (n > 0) {
            n/=2;
           res++;
        }
        return res;
    }

    public static int optimizedOne(int n) {
        int res = 0;
        while (n > 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public static int superOptimizedOne(int n) {
        int table[] = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
        int res = 0;
        while (n > 0) {
            res += table[n & 0xFF];
            n >>= 8;
        }
        return res;
    }

    public static int superOptimizedOneUtil(int n, int[] table) {
        int res = 0;
        while (n > 0) {
            res += table[n & 0xFF];
            n >>= 8;
        }
        return res;
    }

    public static int superOptimizedOneGFG(int n) {
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            count += superOptimizedOneUtil(i, table);
        }
        return count;
    }

    public static void main(String[] args) {
        //optimizedOne(7);
        System.out.println(naiveSol2(7));
       // System.out.println(superOptimizedOneGFG(17));
    }
}
