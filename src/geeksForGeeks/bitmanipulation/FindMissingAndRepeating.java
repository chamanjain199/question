package geeksForGeeks.bitmanipulation;

import java.util.Arrays;

public class FindMissingAndRepeating {
    static int[] findTwoElement(int arr[]) {
        int xor = arr[0] ^ 1;

        for (int i = 1; i < arr.length; i++) {
            xor = xor ^ arr[i] ^ (i + 1);
        }

//        int xor = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {  //XOR all array eleemt
//            xor = xor ^ arr[i];
//        }
//        for (int i = 1; i <=arr.length; i++) {  // number cancel out single present element
//            xor = xor ^ i;
//        }



        int mask = (xor & (-xor));
        int num1 = 0;
        int num2 = 0;
        for (int j = 0; j < arr.length; j++) {  //  cancel out element according to group
            if ((arr[j] & mask) == 0) {
                num1 ^= arr[j];
            } else {
                num2 ^= arr[j];
            }
        }
        for (int j = 1; j <= arr.length; j++) {  //  cancel out element according to group
            if ((j & mask) == 0) {
                num1 ^= j;
            } else {
                num2 ^= j;
            }
        }
        int repeat = 0;
        int missing = 0;
        for (int var :
                arr) {
            if (var == num1) {
                repeat = num1;
                missing = num2;
                break;
            } else if (var == num2) {
                repeat = num2;
                missing = num1;

            }
        }

        return new int[]{repeat, missing};

    }
    int[] findTwoElement(int arr[], int n) {
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
        System.out.println(Arrays.toString(findTwoElement(new int[]{17, 6, 26, 23, 9, 15, 14, 2, 21, 20, 7, 5, 28, 4, 18, 8, 2, 25, 1, 10, 19, 13, 22, 27, 3, 16, 11, 29, 12})));

    }
}
