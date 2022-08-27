package geeksForGeeks.bitmanipulation;

public class MinimumFlipsToMakeAORBEqualToC {
    public static int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bitOfC = (c >> i) & 1;
            int bitOfA = (a >> i) & 1;
            int bitOfB = (b >> i) & 1;
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

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
    }
}
