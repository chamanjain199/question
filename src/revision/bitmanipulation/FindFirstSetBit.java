package revision.bitmanipulation;

public class FindFirstSetBit {
    public static int getFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
        int rs = n & (-n);
        int res = (int) (Math.log(rs) / Math.log(2));

        return res + 1;
    }

    public static void main(String[] args) {

    }
}
