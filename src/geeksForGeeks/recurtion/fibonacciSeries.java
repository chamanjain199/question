package geeksForGeeks.recurtion;

public class fibonacciSeries {
    static int nthOfFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return nthOfFibonacci(n - 2) + nthOfFibonacci(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthOfFibonacci(9));
    }
}
