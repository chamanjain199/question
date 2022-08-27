package geeksForGeeks.bitmanipulation;

public class BitDifference {

    public static int countBitsFlip(int a, int b) {

        int xor = a ^ b;
        int count = 0;
        while (xor > 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
