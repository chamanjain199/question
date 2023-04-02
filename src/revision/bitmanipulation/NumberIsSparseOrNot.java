package revision.bitmanipulation;

public class NumberIsSparseOrNot {
    public static boolean isSparse(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            } else {
                if (count > 0)
                    count--;
            }
            if (count == 2) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSparse(24));
    }
}
