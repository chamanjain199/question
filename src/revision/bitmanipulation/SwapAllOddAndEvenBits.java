package revision.bitmanipulation;

public class SwapAllOddAndEvenBits {
    public static int swapBits(int n) {
        int i = 0;
        int result = 0;
        while (n > 0) {
            int evenBit = n & 1;
            n >>= 1;
            int oddBit = n & 1;
            n >>= 1;
            result |= oddBit << i;
            i++;
            result |= evenBit << i;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
