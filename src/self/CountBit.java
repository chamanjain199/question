package self;

public class CountBit {
    public static int countBits1(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>1;
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(countBits1(15));
    }
}
