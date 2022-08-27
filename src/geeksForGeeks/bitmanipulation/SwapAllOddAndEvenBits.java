package geeksForGeeks.bitmanipulation;

public class SwapAllOddAndEvenBits {
    public static int swapBits(int n) {

        int count = 0;
        int result = 0;
        while (n > 0) {
            int evenBit = n & 1;
            n = n >> 1;
            int oddBit = n & 1;
            n = n >> 1;
            result |= oddBit << count++;
            System.out.println(Integer.toBinaryString(result));
            result |= evenBit << count++;
            System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(swapBits(23));

    }
}
