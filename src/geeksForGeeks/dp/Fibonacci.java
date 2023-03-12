package geeksForGeeks.dp;

public class Fibonacci {

    //TC:(2^N)
    static long nthFibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    static long[] topDown;

    static long nthFibonacciTopDownDriver(long n) {
        topDown = new long[(int) (n + 1)];
        return nthFibonacciTopDown(n);
    }

    //TC :O(N) , SC: O(n)+O(n)
    static long nthFibonacciTopDown(long n) {
        if (n <= 1) {
            return n;
        }
        if (topDown[(int) n] == 0) {
            topDown[(int) n] = (nthFibonacciTopDown(n - 1) + nthFibonacciTopDown(n - 2));
        }
        return topDown[(int) n];
    }

    //TC :O(N) , SC: O(n)

    static long nthFibonacciBottomUp(long n) {
        topDown = new long[(int) (n + 1)];
        topDown[0] = 0;
        topDown[1] = 1;
        for (int i = 2; i <= n; i++) {
            topDown[i] = topDown[i - 1] + topDown[i - 2];
        }
        return topDown[(int) n];
    }

    //TC :O(N) , SC: O(1)
    static long nthFibonacci2(long n) {
        if (n <= 1) {
            return n;
        }
        int firstValue = 0;
        int secondValue = 1;

        for (int i = 2; i <= n; i++) {
            int thirdValue = firstValue + secondValue;
            firstValue = secondValue;
            secondValue = thirdValue;
        }
        return secondValue;
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacci2(5));
    }
}
