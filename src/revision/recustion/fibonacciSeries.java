package revision.recustion;

public class fibonacciSeries {
    static int nthOfFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return nthOfFibonacci(n-2)+nthOfFibonacci(n-1);
    }
}
