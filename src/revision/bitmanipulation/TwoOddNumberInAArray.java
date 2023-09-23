package revision.bitmanipulation;

public class TwoOddNumberInAArray {
    public int[] twoOddNum(int Arr[], int N) {
        int xor = 0;
        for (int i = 0; i < N; i++) {
            xor ^= Arr[i];
        }
        int rightmostSetBit = xor & (-xor);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < N; i++) {
            if ((Arr[i] & rightmostSetBit) != 0) {
                num1 ^= Arr[i];
            } else {
                num2 ^= Arr[i];
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

    }
}
