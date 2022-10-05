package geeksForGeeks.bitmanipulation;

public class FindFirstSetBit {
    public static int getFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
        int rs = n & (-n);
        int res = (int) (Math.log(rs) / Math.log(2));
        return res + 1;
    }
    public static int higestPowerOf2(int n){
        int i=1;
        while (i*2<=n){
            i=i*2;
        }
        return i;
    }
    public static int higestPowerOf2O(int n){
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        System.out.println(5%6);
        System.out.println(8&7);
//        System.out.println(getFirstSetBit(12));
//        System.out.println(higestPowerOf2(9));
//        System.out.println(higestPowerOf2O(9));

    }
}
