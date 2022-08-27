package geeksForGeeks;

import java.util.Arrays;
import java.util.BitSet;

public class IsPrime {
    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean bool[] = new boolean[n];
        Arrays.fill(bool, false);
        int count=0;
        for (int i = 2; i * i < n; i++) {
            if (!bool[i]) {
                continue;
            } else {
                count++;
                for (int j = i * i; j < n; j += i) {
                    bool[j]=false;
                }
            }
        }

        return count;
    }
    public static int countPrimesOptimized(int n) {
        if (n <= 2) return 0;
        int res = n >> 1;  // prime number can only be odd
        int m = (int) Math.sqrt(n - 1);
        boolean[] notPrime = new boolean[n];
        for (int i = 3; i <= m; i += 2) {
            if (!notPrime[i]) {
                System.out.print(i+" , ");
                for (int j = i * i, step = i << 1; j < n; j += step) {
                    if (!notPrime[j]) {
                        notPrime[j] = true;
                        --res;
                    }
                }
            }
        }
        return res;
    }



    static boolean isPrime(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2 || N == 3) {
            return true;
        }
        if (N % 2 == 0 || N % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= N; i = i + 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(countPrimesOptimized(10000));
        //System.out.println(countPrimes(100));
    }
}
