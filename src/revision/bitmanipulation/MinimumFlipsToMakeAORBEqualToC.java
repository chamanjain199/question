package revision.bitmanipulation;

public class MinimumFlipsToMakeAORBEqualToC {
    public static int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int bitOfC = (mask) & c;
            int bitOfA = (mask) & a;
            int bitOfB = (mask) & b;
            if (bitOfC == 0) {
                if (bitOfA == 1) {
                    count++;
                }
                if (bitOfB == 1) {
                    count++;
                }
            } else {
                if (bitOfA == 0 && bitOfB == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
