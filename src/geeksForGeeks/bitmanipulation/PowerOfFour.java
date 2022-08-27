package geeksForGeeks.bitmanipulation;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }


        int shift = 1;
        for (int i = 0; i < 16; i++) {
            if ((n & shift) == n) {
                return true;
            }
            shift<<=2;
        }
        return false;

    }
    public static boolean isPowerOfFour1(int n) {
        return ((n & n - 1) == 0) && (n % 3 == 1);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
