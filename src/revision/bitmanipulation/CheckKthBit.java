package revision.bitmanipulation;

public class CheckKthBit {
    static boolean checkKthBit(int n, int k) {
        int shiftBit = 1 << (k-1);
        return (shiftBit & n)!=0;
    }

    public static void main(String[] args) {
        System.out.println(checkKthBit(7, 2));
    }
}
