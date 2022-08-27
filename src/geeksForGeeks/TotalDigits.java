package geeksForGeeks;

public class TotalDigits {

    static long totalDigits(long n) {
        int totalDigit = 0;
        int mul = 1;
        int counter = 9;
        while (n >= 0) {
            if (n - counter >= 0) {
                n=n-counter;
                totalDigit += counter * mul;
                mul += 1;
                counter *= 10;
            } else {
                totalDigit += n * mul;
                break;
            }
        }
        return totalDigit;
    }


    public static void main(String[] args) {
        System.out.println(totalDigits(120));
    }
}
