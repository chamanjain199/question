package revision.bitmanipulation;

public class BitDifference {
    public static int countBitsFlip(int a, int b) {

        int xor = a ^ b; //mask of bit that are not same in both number
        int count = 0;
        while (xor > 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
