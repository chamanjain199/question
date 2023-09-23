package revision.bitmanipulation;

public class isPowerOfFour {
    boolean isPowerOfFour(int n) {
        int shift = 1;
        for (int i = 0; i < 16; i++) {
            if ((n & shift) == n) {
                return true;
            }
            shift <<= 2;
        }
        return false;
    }
}
