package revision.bitmanipulation;

public class FindMissingAndRepeating {
    static int[] findTwoElement(int arr[]) {
        int xor = 0;
        int len = arr.length;
        for (int i = 1; i <= len; i++) {
            xor = xor ^ i;
        }
        for (int i = 0; i < len; i++) {
            xor = xor ^ arr[i];
        }
        int mask1 = xor & (-xor);
        int m = (int) (Math.log(mask1) / Math.log(2));
        int mask = 1 << m;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < len; i++) {
            if ((arr[i] & mask) == 0) {
                num1 = num1 ^ arr[i];
            } else {
                num2 = num2 ^ arr[i];
            }
        }
        int num3 = 0;
        int num4 = 0;
        for (int i = 0; i <= len; i++) {
            if ((i & mask) == 0) {
                num3 = num3 ^ i;
            } else {
                num4 = num4 ^ i;
            }
        }
        int ans1 = num1 ^ num3;
        int ans2 = num2 ^ num4;
        int repeated = 0;
        int missing = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == ans1) {
                missing = ans2;
                repeated = ans1;
                break;
            } else if (arr[i] == ans2) {
                missing = ans1;
                repeated = ans2;
                break;
            }
        }
        return new int[]{repeated, missing};
    }
}
