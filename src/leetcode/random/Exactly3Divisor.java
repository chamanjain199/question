package leetcode.random;

public class Exactly3Divisor {
    public static boolean isThree(int n) {
        if (n <= 2) {
            return false;
        }
         boolean isPrime=true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i != i) {
                    return false;
                }
                isPrime=false;
            }
        }
        return !isPrime;
    }

    public static void main(String[] args) {
        System.out.println(isThree(4));
    }
}
