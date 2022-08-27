package geeksForGeeks.recurtion;

public class LuckyNumbers {
    public static boolean isLucky(int n) {
        return isLuckySol(n, 2);
    }

    public static boolean isLuckySol(int n, int divide) {
        if (divide == n - 1) {
            return true;
        }
        if (n % divide == 0) {
            return false;
        }
        int dev = n / divide;
        return isLuckySol(n - dev, divide + 1);
    }

    public static void main(String[] args) {
        System.out.println(isLucky(5));
    }
}
