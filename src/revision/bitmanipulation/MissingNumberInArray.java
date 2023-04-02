package revision.bitmanipulation;

public class MissingNumberInArray {

    int MissingNumber(int array[], int n) {
        int xorOfAllUpToN = 1;
        for (int i = 2; i <= n; i++) {
            xorOfAllUpToN = xorOfAllUpToN ^ i;
        }
        for (int i = 0; i < array.length; i++) {
            xorOfAllUpToN = xorOfAllUpToN ^ i;
        }
        return xorOfAllUpToN;
    }

    public static void main(String[] args) {

    }
}
