package self.bitwise;

public class FindMissingAndRepeating {
    static int[] findTwoElement(int arr[], int n) {
        int xor = 0;
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        int lastSetBitMask = xor & (-xor);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & lastSetBitMask) == 0) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
        }
        for (int i = 0; i <= n; i++) {
            if ((i & lastSetBitMask) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (arr[i] == num1) {
                ans[0] = num1;
                ans[1] = num2;
                break;
            } else if (arr[i] == num2) {
                ans[0] = num2;
                ans[1] = num1;
                break;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        System.out.println(findTwoElement(new int[]{1, 3, 3}, 3));


    }
}
